package com.example.gujumenglish.audio

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

class SentenceAudioPlayer(context: Context) : AutoCloseable {
    private val appContext = context.applicationContext
    private val storage = SentenceAudioStorage(appContext)
    private var activePlayer: MediaPlayer? = null

    fun play(
        sentenceId: Int,
        speed: SentenceAudioSpeed = SentenceAudioSpeed.NORMAL,
        onPlaybackStateChanged: (Boolean) -> Unit = {}
    ): Boolean {
        stop()
        val source = storage.find(sentenceId, speed) ?: return false
        val player = MediaPlayer()
        activePlayer = player

        return runCatching {
            when (source) {
                is SentenceAudioSource.Asset -> {
                    appContext.assets.openFd(source.path).use { descriptor ->
                        player.setDataSource(
                            descriptor.fileDescriptor,
                            descriptor.startOffset,
                            descriptor.length
                        )
                    }
                }

                is SentenceAudioSource.Local -> player.setDataSource(source.file.absolutePath)
            }
            player.setOnPreparedListener { prepared ->
                if (activePlayer === prepared) {
                    prepared.start()
                    onPlaybackStateChanged(true)
                } else {
                    prepared.release()
                }
            }
            player.setOnCompletionListener { completed ->
                if (activePlayer === completed) {
                    activePlayer = null
                    onPlaybackStateChanged(false)
                }
                completed.release()
            }
            player.setOnErrorListener { failed, _, _ ->
                Log.w(TAG, "Sentence audio playback failed")
                if (activePlayer === failed) {
                    activePlayer = null
                    onPlaybackStateChanged(false)
                }
                failed.release()
                true
            }
            player.prepareAsync()
            true
        }.getOrElse { error ->
            Log.w(TAG, "Sentence audio source could not be opened", error)
            onPlaybackStateChanged(false)
            if (activePlayer === player) {
                activePlayer = null
            }
            player.release()
            false
        }
    }

    fun stop() {
        activePlayer?.let { player ->
            activePlayer = null
            runCatching {
                if (player.isPlaying) player.stop()
            }
            player.release()
        }
    }

    override fun close() {
        stop()
    }

    private companion object {
        const val TAG = "SentenceAudioPlayer"
    }
}
