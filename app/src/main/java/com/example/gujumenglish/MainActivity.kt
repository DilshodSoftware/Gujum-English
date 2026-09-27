package com.example.gujumenglish

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import coil3.ImageLoader
import com.example.gujumenglish.audio.CapturedAudio
import com.example.gujumenglish.audio.InMemoryAudioPlayer
import com.example.gujumenglish.audio.SentenceAudioPlayer
import com.example.gujumenglish.image.SentenceImageStorage
import com.example.gujumenglish.ui.LearningScreen
import com.example.gujumenglish.ui.LearningViewModel
import com.example.gujumenglish.ui.PracticePhase
import com.example.gujumenglish.ui.grammar.GrammarScreen
import com.example.gujumenglish.ui.grammar.practice.practiceLessonFor
import com.example.gujumenglish.ui.list.SentenceListScreen
import com.example.gujumenglish.ui.navigation.MainBottomNavigation
import com.example.gujumenglish.ui.navigation.MainSection
import com.example.gujumenglish.ui.practice.SentencePracticeScreen
import com.example.gujumenglish.ui.statistics.StatisticsScreen
import com.example.gujumenglish.ui.theme.GujumEnglishTheme
import com.github.awxkee.avifcoil.decoder.HeifDecoder

class MainActivity : ComponentActivity() {
    private lateinit var audioPlayer: SentenceAudioPlayer
    private lateinit var imageLoader: ImageLoader
    private lateinit var sentenceImageStorage: SentenceImageStorage
    private lateinit var speakingSttEngine: MoonshineTinyEngine
    private lateinit var studentAudioPlayer: InMemoryAudioPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        hideAppSystemBars()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        hideAppSystemBars()
        audioPlayer = SentenceAudioPlayer(applicationContext)
        speakingSttEngine = MoonshineTinyEngine(applicationContext)
        studentAudioPlayer = InMemoryAudioPlayer()
        imageLoader = ImageLoader.Builder(applicationContext)
            .components { add(HeifDecoder.Factory()) }
            .build()
        sentenceImageStorage = SentenceImageStorage(applicationContext)
        val learningViewModel = ViewModelProvider(this)[LearningViewModel::class.java]

        setContent {
            val state by learningViewModel.uiState.collectAsState()
            var selectedSection by rememberSaveable { mutableStateOf(MainSection.PRACTICE) }
            var isAudioPlaying by remember { mutableStateOf(false) }
            var isSpeakingEngineReady by remember { mutableStateOf(false) }
            var isSpeakingListening by remember { mutableStateOf(false) }
            var isSpeakingDecoding by remember { mutableStateOf(false) }
            var isStudentAudioPlaying by remember { mutableStateOf(false) }
            var studentAudio by remember { mutableStateOf<CapturedAudio?>(null) }
            var isSpeakingPressActive by remember { mutableStateOf(false) }
            val context = LocalContext.current
            val isSpeakingPhase = state.screen == LearningScreen.PRACTICE &&
                state.practice?.phase == PracticePhase.SPEAKING

            LaunchedEffect(isSpeakingPhase, state.practice?.sentenceIndex) {
                if (isSpeakingPhase) {
                    studentAudioPlayer.stop()
                    isStudentAudioPlaying = false
                    studentAudio = null
                }
            }

            DisposableEffect(isSpeakingPhase) {
                if (isSpeakingPhase) {
                    isSpeakingEngineReady = false
                    learningViewModel.setSpeakingStatus("Moonshine tayyorlanmoqda...")
                    speakingSttEngine.prepare(
                        onReady = {
                            isSpeakingEngineReady = true
                            learningViewModel.setSpeakingStatus(
                                "Tayyor. Gapni aytish uchun tugmani bosib turing."
                            )
                        },
                        onError = { message ->
                            isSpeakingEngineReady = false
                            learningViewModel.setSpeakingStatus(message)
                        }
                    )
                }
                onDispose {
                    if (isSpeakingPhase) {
                        isSpeakingPressActive = false
                        isSpeakingListening = false
                        isSpeakingDecoding = false
                        isSpeakingEngineReady = false
                        studentAudioPlayer.stop()
                        isStudentAudioPlaying = false
                        studentAudio = null
                        speakingSttEngine.release()
                    }
                }
            }

            val startSpeakingNow = {
                if (!isAudioPlaying && isSpeakingEngineReady && !isSpeakingDecoding && !isSpeakingListening) {
                    studentAudioPlayer.stop()
                    isStudentAudioPlaying = false
                    studentAudio = null
                    val accepted = speakingSttEngine.start(
                        onStarted = {
                            learningViewModel.setSpeakingStatus(
                                "Tinglayapti... Tahlil qilish uchun qo‘yib yuboring."
                            )
                        },
                        onFinished = { transcript ->
                            isSpeakingListening = false
                            isSpeakingDecoding = false
                            learningViewModel.submitSpeakingTranscript(transcript)
                        },
                        onError = { message ->
                            isSpeakingListening = false
                            isSpeakingDecoding = false
                            learningViewModel.setSpeakingStatus(message)
                        },
                        onAudioCaptured = { captured ->
                            studentAudio = captured
                        }
                    )
                    if (accepted) {
                        isSpeakingListening = true
                        learningViewModel.setSpeakingStatus("Moonshine ishga tushmoqda...")
                    }
                }
            }

            val permissionLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission()
            ) { granted ->
                if (granted && isSpeakingPressActive) {
                    startSpeakingNow()
                } else if (!granted) {
                    isSpeakingPressActive = false
                    learningViewModel.setSpeakingStatus(
                        "Speaking uchun mikrofon ruxsati kerak."
                    )
                }
            }

            val startSpeaking = {
                if (!isAudioPlaying &&
                    !isSpeakingListening &&
                    !isSpeakingDecoding &&
                    !isSpeakingPressActive
                ) {
                    isSpeakingPressActive = true
                    if (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.RECORD_AUDIO
                    ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        startSpeakingNow()
                    } else {
                        permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                    }
                }
            }
            val stopSpeaking = {
                isSpeakingPressActive = false
                if (isSpeakingListening && !isSpeakingDecoding) {
                    isSpeakingDecoding = true
                    speakingSttEngine.stop()
                    learningViewModel.setSpeakingStatus("Tahlil qilinmoqda...")
                }
            }

            GujumEnglishTheme {
                val leavePractice = {
                    audioPlayer.stop()
                    isSpeakingPressActive = false
                    isSpeakingListening = false
                    isSpeakingDecoding = false
                    studentAudioPlayer.stop()
                    isStudentAudioPlaying = false
                    studentAudio = null
                    learningViewModel.backToList()
                }

                BackHandler(
                    enabled = state.screen == LearningScreen.PRACTICE,
                    onBack = leavePractice
                )

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets(0, 0, 0, 0),
                    bottomBar = {
                        if (state.screen == LearningScreen.LIST) {
                            MainBottomNavigation(
                                selectedSection = selectedSection,
                                onSectionSelected = { selectedSection = it }
                            )
                        }
                    }
                ) { innerPadding ->
                    when (state.screen) {
                        LearningScreen.LIST -> {
                            when (selectedSection) {
                                MainSection.GRAMMAR -> {
                                    GrammarScreen(
                                        onOpenLesson = { assetName, lessonTitle, testLesson ->
                                            val quizLesson = practiceLessonFor(testLesson)
                                            if (quizLesson != null) {
                                                startActivity(
                                                    Intent(
                                                        this@MainActivity,
                                                        GrammarPracticeActivity::class.java
                                                    ).apply {
                                                        putExtra(
                                                            GrammarPracticeActivity.EXTRA_LESSON_NUMBER,
                                                            quizLesson
                                                        )
                                                    }
                                                )
                                            } else {
                                                startActivity(
                                                    Intent(
                                                        this@MainActivity,
                                                        GrammarLessonActivity::class.java
                                                    ).apply {
                                                        putExtra(
                                                            GrammarLessonActivity.EXTRA_ASSET_NAME,
                                                            assetName
                                                        )
                                                        putExtra(
                                                            GrammarLessonActivity.EXTRA_LESSON_TITLE,
                                                            lessonTitle
                                                        )
                                                    }
                                                )
                                            }
                                        },
                                        modifier = Modifier.padding(innerPadding)
                                    )
                                }

                                MainSection.STATISTICS -> {
                                    StatisticsScreen(
                                        learnedSentencePagingFlow = learningViewModel.learnedSentencePagingFlow,
                                        unlearnedSentencePagingFlow = learningViewModel.unlearnedSentencePagingFlow,
                                        learnedCount = state.learnedSentenceCount,
                                        totalCount = state.totalSentenceCount,
                                        modifier = Modifier.padding(innerPadding)
                                    )
                                }

                                MainSection.PRACTICE -> {
                                    SentenceListScreen(
                                        sentencePagingFlow = learningViewModel.sentencePagingFlow,
                                        learnedCount = state.learnedSentenceCount,
                                        totalCount = state.totalSentenceCount,
                                        lastLearnedSentencePosition = state.lastLearnedSentencePosition,
                                        onStartLearning = learningViewModel::startLearningSession,
                                        onClearProgress = learningViewModel::clearLearnedProgress,
                                        showSentenceList = false,
                                        modifier = Modifier.padding(innerPadding)
                                    )
                                }
                            }
                        }

                        LearningScreen.PRACTICE -> {
                            state.practice?.let { practiceState ->
                                SentencePracticeScreen(
                                    state = practiceState,
                                    imageLoader = imageLoader,
                                    imageModelForSentence = sentenceImageStorage::coilModel,
                                    isAudioPlaying = isAudioPlaying,
                                    onPlayAudio = { sentenceId, speed ->
                                        studentAudioPlayer.stop()
                                        isStudentAudioPlaying = false
                                        val started = audioPlayer.play(
                                            sentenceId,
                                            speed,
                                            onPlaybackStateChanged = { playing ->
                                                isAudioPlaying = playing
                                            }
                                        )
                                        if (!started) {
                                            isAudioPlaying = false
                                        }
                                    },
                                    onLearned = {
                                        audioPlayer.stop()
                                        isAudioPlaying = false
                                        learningViewModel.markSentenceLearned()
                                    },
                                    isSpeakingEngineReady = isSpeakingEngineReady,
                                    isSpeakingListening = isSpeakingListening,
                                    isSpeakingDecoding = isSpeakingDecoding,
                                    isSpeakingAnswerCorrect = practiceState.isSpeakingAnswerCorrect,
                                    onSpeakingStart = startSpeaking,
                                    onSpeakingStop = stopSpeaking,
                                    onSpeakingNext = {
                                        audioPlayer.stop()
                                        isAudioPlaying = false
                                        studentAudioPlayer.stop()
                                        isStudentAudioPlaying = false
                                        studentAudio = null
                                        learningViewModel.nextSpeakingSentence()
                                    },
                                    onTestAnswerSelected = learningViewModel::selectTestAnswer,
                                    onTestNext = learningViewModel::nextTestQuestion,
                                    hasStudentAudio = studentAudio != null,
                                    isStudentAudioPlaying = isStudentAudioPlaying,
                                    onPlayStudentAudio = {
                                        val captured = studentAudio
                                        if (captured != null) {
                                            audioPlayer.stop()
                                            isAudioPlaying = false
                                            val started = studentAudioPlayer.play(
                                                samples = captured.samples,
                                                sampleRate = captured.sampleRate,
                                                onPlaybackStateChanged = { playing ->
                                                    isStudentAudioPlaying = playing
                                                }
                                            )
                                            if (!started) {
                                                isStudentAudioPlaying = false
                                            }
                                        }
                                    },
                                    onBack = leavePractice,
                                    modifier = Modifier.padding(innerPadding)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideAppSystemBars()
        }
    }

    override fun onDestroy() {
        speakingSttEngine.release()
        studentAudioPlayer.close()
        audioPlayer.close()
        super.onDestroy()
    }
}

