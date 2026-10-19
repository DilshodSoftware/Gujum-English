package com.example.gujumenglish.audio

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

/**
 * Kartalar uchun audio player.
 *
 * Kartalar `audioFile` maydonida to'liq asset yo'lini saqlaydi
 * (masalan `grammar/UnitAllLessons/unit_0/unit_0_sentence_opus/s002_075.opus`).
 */
class CardAudioPlayer(context: Context) : AutoCloseable {
    private val appContext = context.applicationContext
    private var activePlayer: MediaPlayer? = null

    fun play(assetPath: String, onPlaybackStateChanged: (Boolean) -> Unit = {}): Boolean {
        stop()
        val player = MediaPlayer()
        activePlayer = player
        return runCatching {
            appContext.assets.openFd(assetPath).use { descriptor ->
                player.setDataSource(
                    descriptor.fileDescriptor,
                    descriptor.startOffset,
                    descriptor.length
                )
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
                Log.w(TAG, "Card audio playback failed: $assetPath")
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
            Log.w(TAG, "Card audio source could not be opened: $assetPath", error)
            onPlaybackStateChanged(false)
            if (activePlayer === player) activePlayer = null
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
        const val TAG = "CardAudioPlayer"
    }
}
