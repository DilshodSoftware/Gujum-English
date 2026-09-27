package com.example.gujumenglish.image

import android.content.Context
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.security.MessageDigest
import java.util.zip.ZipInputStream
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImagePackInstaller(context: Context) {
    private val appContext = context.applicationContext
    private val storage = SentenceImageStorage(appContext)

    suspend fun installFromReleaseZip(
        url: String,
        expectedSha256: String? = null
    ): Result<Int> = runCatching {
        withContext(Dispatchers.IO) {
            require(url.startsWith("https://")) { "Image pack URL must use HTTPS" }
            val stagingRoot = File(appContext.cacheDir, "image-pack-staging")
            val archive = File(appContext.cacheDir, "image-pack.zip")
            stagingRoot.deleteRecursively()
            archive.delete()
            stagingRoot.mkdirs()

            try {
                download(url, archive)
                if (expectedSha256 != null) {
                    check(sha256(archive).equals(expectedSha256, ignoreCase = true)) {
                        "Image pack checksum mismatch"
                    }
                }

                extractSafely(archive, stagingRoot)
                val manifest = File(stagingRoot, "manifest.json")
                val imageDirectory = File(stagingRoot, "images")
                check(manifest.isFile) { "Image pack manifest is missing" }
                check(imageDirectory.isDirectory) { "Image pack images directory is missing" }
                val fileCount = imageDirectory
                    .walkTopDown()
                    .count { it.isFile && it.extension.equals("avif", ignoreCase = true) }
                check(fileCount > 0) { "Image pack contains no AVIF files" }

                val current = storage.downloadedRoot
                manifest.copyTo(File(imageDirectory, "manifest.json"), overwrite = true)
                val backup = File(appContext.filesDir, "images-backup")
                backup.deleteRecursively()
                if (current.isDirectory) check(current.renameTo(backup)) {
                    "Could not stage the current image pack"
                }
                try {
                    check(imageDirectory.renameTo(current)) {
                        "Could not activate the new image pack"
                    }
                    backup.deleteRecursively()
                } catch (error: Throwable) {
                    current.deleteRecursively()
                    backup.renameTo(current)
                    throw error
                }
                fileCount
            } finally {
                stagingRoot.deleteRecursively()
                archive.delete()
            }
        }
    }

    private fun download(url: String, target: File) {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.connectTimeout = NETWORK_TIMEOUT_MS
        connection.readTimeout = NETWORK_TIMEOUT_MS
        connection.instanceFollowRedirects = true
        try {
            check(connection.responseCode in 200..299) {
                "Image pack download failed: HTTP ${connection.responseCode}"
            }
            connection.inputStream.use { input ->
                FileOutputStream(target).use { output -> input.copyTo(output) }
            }
        } finally {
            connection.disconnect()
        }
    }

    private fun extractSafely(archive: File, target: File) {
        val canonicalRoot = target.canonicalFile
        ZipInputStream(FileInputStream(archive)).use { zip ->
            while (true) {
                val entry = zip.nextEntry ?: break
                val output = File(target, entry.name).canonicalFile
                check(output.path.startsWith(canonicalRoot.path + File.separator)) {
                    "Unsafe path in image pack"
                }
                if (entry.isDirectory) {
                    output.mkdirs()
                } else {
                    output.parentFile?.mkdirs()
                    FileOutputStream(output).use { zip.copyTo(it) }
                }
                zip.closeEntry()
            }
        }
    }

    private fun sha256(file: File): String {
        val digest = MessageDigest.getInstance("SHA-256")
        file.inputStream().use { input ->
            val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
            while (true) {
                val read = input.read(buffer)
                if (read < 0) break
                digest.update(buffer, 0, read)
            }
        }
        return digest.digest().joinToString("") { byte -> "%02x".format(byte) }
    }

    private companion object {
        const val NETWORK_TIMEOUT_MS = 20_000
    }
}
