# STT model status

## Verified Android runtime

- Runtime: `com.github.k2-fsa.sherpa-onnx:sherpa-onnx:v1.13.5`
- Repository: JitPack (`https://jitpack.io`)
- Android support: official sherpa-onnx Java for Android documentation
- Native libraries are packaged by Gradle for `arm64-v8a`, `armeabi-v7a`, `x86` and `x86_64`.
- `minSdk=26` remains compatible with this app.

## Verified 2026 English model package

- Moonshine Tiny English quantized — `2026-02-27`
  - Archive: `https://github.com/k2-fsa/sherpa-onnx/releases/download/asr-models/sherpa-onnx-moonshine-tiny-en-quantized-2026-02-27.tar.bz2`
  - Bundled extracted files: `encoder_model.ort`, `decoder_model_merged.ort`, `tokens.txt`.
  - Approximate model size: 43 MB.
  - English-only, 16 kHz input.

The Base model was intentionally removed to keep the app Tiny-only and reduce APK/storage/RAM pressure.

## Registry entry

The test Activity now keeps one model entry:

- Moonshine v2 Tiny English — 2026 package, bundled in app assets and connected to the native microphone inference pipeline.

Android SpeechRecognizer and Moonshine Base were removed from the test registry. This screen now tests only the requested on-device Tiny model.

## Settings implemented in the test panel

- Language: `en-US`
- Sample rate: fixed 16 kHz PCM AudioRecord capture
- Partial results: off for one-shot Tiny decode; final transcript is returned after Stop
- VAD threshold: 0.10–0.90
- Confidence gate: 0.50–1.00, default 0.85
- Silence timeout: 300–1500 ms, default 800 ms
- Capture mode: push-to-talk; hold the button while speaking and release it to decode
- Capture limit: 6 seconds per utterance for Moonshine Tiny decoder stability

VAD, confidence and silence values remain available in the test panel, but no target phrase or transcript equality check is applied. Tiny captures 16 kHz PCM from the microphone and performs one-shot on-device decoding when the push-to-talk button is released.

## General transcription behavior

The screen displays whatever English speech is recognized by Moonshine Tiny. It does not compare the transcript with a predefined sentence and does not show PASS/REJECT pronunciation results.

## Install validation

The app build and unit tests pass with the Tiny-only native pipeline:

```text
BUILD SUCCESSFUL
:app:assembleDebug
:app:testDebugUnitTest
APK: approximately 378.74 MB total
Tiny STT assets: approximately 42.21 MB
```

The APK contains only the Tiny model under `app/src/main/assets/stt/tiny_en_2026_02_27/`. Base model files are not packaged.

## Single-active-engine policy

- The Activity owns one lazy Tiny STT engine controller.
- The Tiny model session is created only for the selected test and is released when the Activity leaves.
- The model registry contains only Moonshine Tiny; Base and platform fallback are removed.
- Stopping a recording cancels microphone capture, then decodes the captured buffer once on-device.
- The model registry does not preload duplicate model sessions into RAM.


## Learning speaking integration

- After all sentences in the learning phase are marked learned, the session enters a speaking repetition phase instead of returning immediately to the list.
- One persistent Moonshine Tiny recognizer is prepared when speaking begins and reused for every push-to-talk repetition.
- Press-and-hold captures one utterance; release stops capture and runs the decode. A new repetition is blocked while the previous decode is still running.
- The normalized transcript is compared with the current English sentence only in the learning repetition flow. A match advances to the next sentence; a mismatch keeps the same sentence for another attempt.
- The recognizer is released when all repetitions succeed, the user leaves practice, or the Activity is destroyed. The standalone STT test remains generic transcription without target checking.


## Speaking recording playback

- During the learning speaking phase, the original English sentence can be played from the existing sentence audio package.
- After each push-to-talk capture, the raw 16 kHz mono PCM is kept only in memory for the current speaking sentence and can be replayed with `Your recording`.
- Student PCM is never written to app files or other persistent storage. It is cleared when moving to another sentence, leaving the speaking session, or destroying the Activity.
