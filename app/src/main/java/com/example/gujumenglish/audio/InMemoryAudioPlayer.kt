package com.example.gujumenglish.audio

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import android.os.Handler
import android.os.Looper

data class CapturedAudio(
    val samples: ShortArray,
    val sampleRate: Int
)

/**
 * Plays one short PCM recording directly from memory. No file is created.
 */
class InMemoryAudioPlayer : AutoCloseable {
    private val mainHandler = Handler(Looper.getMainLooper())
    private var activeTrack: AudioTrack? = null
    private var activeCallback: ((Boolean) -> Unit)? = null

    @Synchronized
    fun play(
        samples: ShortArray,
        sampleRate: Int,
        onPlaybackStateChanged: (Boolean) -> Unit = {}
    ): Boolean {
        stop()
        if (samples.isEmpty() || sampleRate <= 0) return false

        val bufferSize = maxOf(samples.size * 2, sampleRate / 5 * 2)
        val track = runCatching {
            AudioTrack.Builder()
                .setAudioAttributes(
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                        .build()
                )
                .setAudioFormat(
                    AudioFormat.Builder()
                        .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                        .setSampleRate(sampleRate)
                        .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                        .build()
                )
                .setBufferSizeInBytes(bufferSize)
                .setTransferMode(AudioTrack.MODE_STATIC)
                .build()
        }.getOrNull() ?: return false

        val written = track.write(samples, 0, samples.size)
        if (written != samples.size) {
            track.release()
            return false
        }

        track.setPlaybackPositionUpdateListener(
            object : AudioTrack.OnPlaybackPositionUpdateListener {
                override fun onMarkerReached(audioTrack: AudioTrack) {
                    finish(audioTrack)
                }

                override fun onPeriodicNotification(audioTrack: AudioTrack) = Unit
            },
            mainHandler
        )
        track.setNotificationMarkerPosition(samples.size)
        activeTrack = track
        activeCallback = onPlaybackStateChanged

        return runCatching {
            track.play()
            post { onPlaybackStateChanged(true) }
            true
        }.getOrElse {
            if (activeTrack === track) {
                activeTrack = null
                activeCallback = null
            }
            track.release()
            false
        }
    }

    @Synchronized
    fun stop() {
        val track = activeTrack ?: return
        val callback = activeCallback
        activeTrack = null
        activeCallback = null
        runCatching {
            if (track.playState == AudioTrack.PLAYSTATE_PLAYING) {
                track.stop()
            }
        }
        track.release()
        callback?.let { post { it(false) } }
    }

    override fun close() {
        stop()
    }

    @Synchronized
    private fun finish(track: AudioTrack) {
        if (activeTrack !== track) return
        val callback = activeCallback
        activeTrack = null
        activeCallback = null
        track.release()
        callback?.let { post { it(false) } }
    }

    private fun post(action: () -> Unit) {
        mainHandler.post(action)
    }
}
