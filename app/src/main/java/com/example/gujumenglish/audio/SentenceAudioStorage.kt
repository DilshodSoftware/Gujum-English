package com.example.gujumenglish.audio

import android.content.Context
import java.io.File

private const val AUDIO_ASSET_ROOT = "audio"
private const val AUDIO_STORAGE_DIRECTORY = "audio"

enum class SentenceAudioSpeed(val code: String) {
    SLOW("070"),
    NORMAL("080"),
    FAST("095")
}

sealed interface SentenceAudioSource {
    data class Asset(val path: String) : SentenceAudioSource
    data class Local(val file: File) : SentenceAudioSource
}

object SentenceAudioNaming {
    fun fileName(sentenceId: Int, speed: SentenceAudioSpeed): String =
        "s${sentenceId.toString().padStart(3, '0')}_${speed.code}.opus"

    fun relativePath(sentenceId: Int, speed: SentenceAudioSpeed): String =
        "$AUDIO_ASSET_ROOT/${fileName(sentenceId, speed)}"
}

class SentenceAudioStorage(context: Context) {
    private val appContext = context.applicationContext
    val downloadedRoot: File = File(appContext.filesDir, AUDIO_STORAGE_DIRECTORY)

    fun find(
        sentenceId: Int,
        speed: SentenceAudioSpeed = SentenceAudioSpeed.NORMAL
    ): SentenceAudioSource? {
        val fileName = SentenceAudioNaming.fileName(sentenceId, speed)
        val downloadedFile = File(downloadedRoot, fileName)
        if (downloadedFile.isFile && downloadedFile.length() > 0L) {
            return SentenceAudioSource.Local(downloadedFile)
        }

        val assetPath = "$AUDIO_ASSET_ROOT/$fileName"
        val assetExists = runCatching {
            appContext.assets.open(assetPath).use { }
            true
        }.getOrDefault(false)
        return assetPath.takeIf { assetExists }?.let(SentenceAudioSource::Asset)
    }
}
