package com.example.gujumenglish.image

import android.content.Context
import java.io.File

private const val IMAGE_ASSET_ROOT = "images"
private const val IMAGE_STORAGE_DIRECTORY = "images"

sealed interface SentenceImageSource {
    data class Asset(val path: String) : SentenceImageSource
    data class Local(val file: File) : SentenceImageSource
}

object SentenceImageNaming {
    fun fileName(sentenceId: Int): String =
        "s${sentenceId.toString().padStart(4, '0')}.avif"

    fun relativePath(sentenceId: Int): String =
        "$IMAGE_ASSET_ROOT/${fileName(sentenceId)}"
}

class SentenceImageStorage(context: Context) {
    private val appContext = context.applicationContext
    val downloadedRoot: File = File(appContext.filesDir, IMAGE_STORAGE_DIRECTORY)

    fun coilModel(sentenceId: Int): Any? = when (val source = find(sentenceId)) {
        is SentenceImageSource.Asset -> "file:///android_asset/${source.path}"
        is SentenceImageSource.Local -> source.file
        null -> null
    }

    fun find(sentenceId: Int): SentenceImageSource? {
        val fileName = SentenceImageNaming.fileName(sentenceId)
        val downloadedFile = File(downloadedRoot, fileName)
        if (downloadedFile.isFile && downloadedFile.length() > 0L) {
            return SentenceImageSource.Local(downloadedFile)
        }

        val assetPath = "$IMAGE_ASSET_ROOT/$fileName"
        val assetExists = runCatching {
            appContext.assets.open(assetPath).use { }
            true
        }.getOrDefault(false)
        return assetPath.takeIf { assetExists }?.let(SentenceImageSource::Asset)
    }
}
