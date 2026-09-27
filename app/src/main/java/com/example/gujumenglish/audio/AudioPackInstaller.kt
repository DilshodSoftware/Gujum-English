package com.example.gujumenglish.audio

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

class AudioPackInstaller(context: Context) {
    private val appContext = context.applicationContext
    private val storage = SentenceAudioStorage(appContext)

    suspend fun installFromReleaseZip(
        url: String,
        expectedSha256: String? = null
    ): Result<Int> = runCatching {
        withContext(Dispatchers.IO) {
            require(url.startsWith("https://")) { "Audio pack URL must use HTTPS" }
            val stagingRoot = File(appContext.cacheDir, "audio-pack-staging")
            val archive = File(appContext.cacheDir, "audio-pack.zip")
            stagingRoot.deleteRecursively()
            archive.delete()
            stagingRoot.mkdirs()

            download(url, archive)
            if (expectedSha256 != null) {
                check(sha256(archive).equals(expectedSha256, ignoreCase = true)) {
                    "Audio pack checksum mismatch"
                }
            }

            extractSafely(archive, stagingRoot)
            val incomingAudio = File(stagingRoot, "audio")
            check(File(incomingAudio, "manifest.json").isFile) {
                "Audio pack manifest is missing"
            }
            val fileCount = incomingAudio
                .walkTopDown()
                .count { it.isFile && it.extension == "opus" }
            check(fileCount > 0) { "Audio pack contains no Opus files" }

            val current = storage.downloadedRoot
            val backup = File(appContext.filesDir, "audio-backup")
            backup.deleteRecursively()
            if (current.isDirectory) check(current.renameTo(backup)) {
                "Could not stage the current audio pack"
            }
            try {
                check(incomingAudio.renameTo(current)) {
                    "Could not activate the new audio pack"
                }
                backup.deleteRecursively()
            } catch (error: Throwable) {
                current.deleteRecursively()
                backup.renameTo(current)
                throw error
            } finally {
                stagingRoot.deleteRecursively()
                archive.delete()
            }
            fileCount
        }
    }

    private fun download(url: String, target: File) {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.connectTimeout = NETWORK_TIMEOUT_MS
        connection.readTimeout = NETWORK_TIMEOUT_MS
        connection.instanceFollowRedirects = true
        try {
            check(connection.responseCode in 200..299) {
                "Audio pack download failed: HTTP ${connection.responseCode}"
            }
            connection.inputStream.use { input ->
                FileOutputStream(target).use { output ->
                    input.copyTo(output)
                }
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
                    "Unsafe path in audio pack"
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
