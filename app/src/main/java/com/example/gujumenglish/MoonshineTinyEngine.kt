package com.example.gujumenglish

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import com.example.gujumenglish.audio.CapturedAudio
import com.k2fsa.sherpa.onnx.FeatureConfig
import com.k2fsa.sherpa.onnx.OfflineMoonshineModelConfig
import com.k2fsa.sherpa.onnx.OfflineModelConfig
import com.k2fsa.sherpa.onnx.OfflineRecognizer
import com.k2fsa.sherpa.onnx.OfflineRecognizerConfig
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Fully on-device Moonshine v2 Tiny recognizer.
 *
 * The recognizer is prepared once for a speaking session and reused for every
 * push-to-talk capture. It is released only when the session ends.
 */
class MoonshineTinyEngine(private val context: Context) {
    companion object {
        private const val SAMPLE_RATE = 16_000
        // Moonshine v2 Tiny's offline decoder must receive a short utterance.
        // Longer buffers can exceed the decoder's attention shape and return an empty result.
        private const val MAX_SECONDS = 10
        private const val SPEECH_FRAME_SAMPLES = SAMPLE_RATE / 50
        private const val SPEECH_RMS_THRESHOLD = 0.01f
        private const val SPEECH_PADDING_SAMPLES = SAMPLE_RATE / 5
        private const val MODEL_DIR = "stt/tiny_en_2026_02_27"
    }

    private val mainHandler = Handler(Looper.getMainLooper())
    private val lifecycleLock = Any()
    private val running = AtomicBoolean(false)
    private val busy = AtomicBoolean(false)
    private val preparing = AtomicBoolean(false)
    private var recorder: AudioRecord? = null
    private var worker: Thread? = null
    private var prepareWorker: Thread? = null
    private var recognizer: OfflineRecognizer? = null

    private data class SpeechAudio(
        val samples: FloatArray,
        val pcmSamples: ShortArray
    )

    fun prepare(
        onReady: () -> Unit,
        onError: (String) -> Unit
    ) {
        synchronized(lifecycleLock) {
            if (recognizer != null) {
                post(onReady)
                return
            }
            if (!preparing.compareAndSet(false, true)) return
        }

        prepareWorker = Thread {
            try {
                val createdRecognizer = createRecognizer()
                val keepRecognizer = synchronized(lifecycleLock) {
                    if (preparing.get()) {
                        recognizer = createdRecognizer
                        true
                    } else {
                        false
                    }
                }
                if (keepRecognizer) {
                    post(onReady)
                } else {
                    createdRecognizer.release()
                }
            } catch (error: Throwable) {
                post { onError(error.message ?: "Moonshine Tiny could not be prepared.") }
            } finally {
                preparing.set(false)
            }
        }.also { it.start() }
    }

    fun start(
        onStarted: () -> Unit,
        onFinished: (String) -> Unit,
        onError: (String) -> Unit,
        onAudioCaptured: (CapturedAudio) -> Unit = {}
    ): Boolean {
        if (!busy.compareAndSet(false, true)) return false
        if (!running.compareAndSet(false, true)) {
            busy.set(false)
            return false
        }

        worker = Thread {
            try {
                if (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.RECORD_AUDIO
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    throw IllegalStateException("Microphone permission is missing.")
                }

                val modelRecognizer = synchronized(lifecycleLock) {
                    recognizer ?: createRecognizer().also { recognizer = it }
                }
                val minBuffer = AudioRecord.getMinBufferSize(
                    SAMPLE_RATE,
                    AudioFormat.CHANNEL_IN_MONO,
                    AudioFormat.ENCODING_PCM_16BIT
                )
                if (minBuffer <= 0) {
                    throw IllegalStateException("AudioRecord buffer could not be created.")
                }

                val bufferSize = maxOf(minBuffer, SAMPLE_RATE / 2)
                val audioRecord = AudioRecord(
                    MediaRecorder.AudioSource.VOICE_RECOGNITION,
                    SAMPLE_RATE,
                    AudioFormat.CHANNEL_IN_MONO,
                    AudioFormat.ENCODING_PCM_16BIT,
                    bufferSize * 2
                )
                if (audioRecord.state != AudioRecord.STATE_INITIALIZED) {
                    audioRecord.release()
                    throw IllegalStateException("AudioRecord could not be initialized.")
                }
                recorder = audioRecord

                val samples = FloatArray(SAMPLE_RATE * MAX_SECONDS)
                val pcmSamples = ShortArray(SAMPLE_RATE * MAX_SECONDS)
                val pcmBuffer = ShortArray(bufferSize)
                var sampleCount = 0
                audioRecord.startRecording()
                post(onStarted)

                while (running.get() && sampleCount < samples.size) {
                    val read = audioRecord.read(pcmBuffer, 0, pcmBuffer.size)
                    if (read > 0) {
                        val copyCount = minOf(read, samples.size - sampleCount)
                        for (index in 0 until copyCount) {
                            val sample = pcmBuffer[index]
                            pcmSamples[sampleCount + index] = sample
                            samples[sampleCount + index] = sample / 32768.0f
                        }
                        sampleCount += copyCount
                    }
                }

                audioRecord.stop()
                audioRecord.release()
                recorder = null
                running.set(false)

                if (sampleCount < SAMPLE_RATE / 5) {
                    throw IllegalStateException("No speech was recorded.")
                }

                val speechAudio = trimSilence(samples, pcmSamples, sampleCount)
                val capturedAudio = CapturedAudio(
                    samples = speechAudio.pcmSamples,
                    sampleRate = SAMPLE_RATE
                )
                post { onAudioCaptured(capturedAudio) }
                val stream = modelRecognizer.createStream()
                stream.use {
                    it.acceptWaveform(speechAudio.samples, SAMPLE_RATE)
                    modelRecognizer.decode(it)
                    val resultText = modelRecognizer.getResult(it).text.trim()
                    if (resultText.isBlank()) {
                        throw IllegalStateException(
                            "Moonshine returned an empty result. Speak clearly and try again."
                        )
                    }
                    post { onFinished(resultText) }
                }
            } catch (error: Throwable) {
                running.set(false)
                recorder?.release()
                recorder = null
                post { onError(error.message ?: "Moonshine Tiny recognition failed.") }
            } finally {
                busy.set(false)
            }
        }.also { it.start() }
        return true
    }

    fun stop() {
        // Do not call AudioRecord.stop() on the Compose/main thread. The native
        // call can block while a read is in progress and make the activity appear frozen.
        running.set(false)
    }

    fun release() {
        running.set(false)
        val captureThread = worker
        if (captureThread != null && captureThread !== Thread.currentThread()) {
            runCatching { captureThread.join(1500) }
        }
        worker = null

        val modelThread = prepareWorker
        if (modelThread != null && modelThread !== Thread.currentThread()) {
            preparing.set(false)
            runCatching { modelThread.join(1500) }
        }
        prepareWorker = null

        synchronized(lifecycleLock) {
            recognizer?.release()
            recognizer = null
        }
        busy.set(false)
    }

    private fun trimSilence(
        samples: FloatArray,
        pcmSamples: ShortArray,
        sampleCount: Int
    ): SpeechAudio {
        val thresholdSquared = SPEECH_RMS_THRESHOLD * SPEECH_RMS_THRESHOLD
        var firstSpeechSample = -1
        var lastSpeechSample = -1
        var frameStart = 0

        while (frameStart < sampleCount) {
            val frameEnd = minOf(frameStart + SPEECH_FRAME_SAMPLES, sampleCount)
            var energy = 0.0
            for (index in frameStart until frameEnd) {
                val value = samples[index].toDouble()
                energy += value * value
            }
            val frameSize = frameEnd - frameStart
            val rmsSquared = (energy / frameSize).toFloat()
            if (rmsSquared >= thresholdSquared) {
                if (firstSpeechSample < 0) {
                    firstSpeechSample = frameStart
                }
                lastSpeechSample = frameEnd
            }
            frameStart = frameEnd
        }

        if (firstSpeechSample < 0) {
            throw IllegalStateException("No speech was detected. Speak clearly and try again.")
        }

        val start = (firstSpeechSample - SPEECH_PADDING_SAMPLES).coerceAtLeast(0)
        val end = (lastSpeechSample + SPEECH_PADDING_SAMPLES).coerceAtMost(sampleCount)
        return SpeechAudio(
            samples = samples.copyOfRange(start, end),
            pcmSamples = pcmSamples.copyOfRange(start, end)
        )
    }

    private fun createRecognizer(): OfflineRecognizer {
        return OfflineRecognizer(
            assetManager = context.assets,
            config = OfflineRecognizerConfig(
                featConfig = FeatureConfig(
                    sampleRate = SAMPLE_RATE,
                    featureDim = 80
                ),
                modelConfig = OfflineModelConfig(
                    moonshine = OfflineMoonshineModelConfig(
                        encoder = "$MODEL_DIR/encoder_model.ort",
                        mergedDecoder = "$MODEL_DIR/decoder_model_merged.ort"
                    ),
                    tokens = "$MODEL_DIR/tokens.txt",
                    numThreads = 2,
                    modelType = "moonshine"
                )
            )
        )
    }

    private fun post(action: () -> Unit) {
        mainHandler.post(action)
    }
}
