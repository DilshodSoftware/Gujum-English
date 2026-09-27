package com.example.gujumenglish.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.gujumenglish.data.LearningRepository
import com.example.gujumenglish.data.Sentence
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.math.abs

private val SESSION_SIZES = setOf(1, 3, 6, 9)
private val TEST_STOP_WORDS = setOf(
    "a", "an", "the", "am", "is", "are", "was", "were", "be", "to", "of", "in", "on",
    "at", "for", "and", "or", "but", "i", "you", "he", "she", "it", "we", "they"
)

enum class LearningScreen {
    LIST,
    PRACTICE
}

enum class PracticePhase {
    LEARNING,
    SPEAKING,
    TEST
}

data class PracticeUiState(
    val sentences: List<Sentence> = emptyList(),
    val sentenceIndex: Int = 0,
    val phase: PracticePhase = PracticePhase.LEARNING,
    val speakingTranscript: String = "",
    val speakingStatus: String = "",
    val isSpeakingAnswerCorrect: Boolean = false,
    val testOptions: List<String> = emptyList(),
    val selectedTestAnswer: String? = null,
    val isTestAnswerCorrect: Boolean? = null,
    val testScore: Int = 0,
    val isActionInProgress: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
    val sentence: Sentence?
        get() = sentences.getOrNull(sentenceIndex)
}

data class LearningUiState(
    val screen: LearningScreen = LearningScreen.LIST,
    val learnedSentenceCount: Int = 0,
    val totalSentenceCount: Int = 0,
    val lastLearnedSentencePosition: Int = 0,
    val practice: PracticeUiState? = null
)

class LearningViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = LearningRepository(application)
    private val clearProgressInProgress = AtomicBoolean(false)
    private val _uiState = MutableStateFlow(LearningUiState())
    val uiState: StateFlow<LearningUiState> = _uiState.asStateFlow()

    val sentencePagingFlow: Flow<PagingData<Sentence>> = repository
        .sentencePagingFlow()
        .cachedIn(viewModelScope)

    val learnedSentencePagingFlow: Flow<PagingData<Sentence>> = repository
        .learnedSentencePagingFlow()
        .cachedIn(viewModelScope)

    val unlearnedSentencePagingFlow: Flow<PagingData<Sentence>> = repository
        .unlearnedSentencePagingFlow()
        .cachedIn(viewModelScope)

    init {
        viewModelScope.launch {
            combine(
                repository.observeLearnedSentenceCount(),
                repository.observeSentenceCount(),
                repository.observeLastLearnedSentencePosition()
            ) { learnedCount, totalCount, lastLearnedPosition ->
                Triple(learnedCount, totalCount, lastLearnedPosition)
            }
                .catch { error ->
                    _uiState.update { state ->
                        state.copy(
                            learnedSentenceCount = 0,
                            totalSentenceCount = 0,
                            practice = PracticeUiState(
                                errorMessage = error.message ?: "Gaplar sonini yuklab bo‘lmadi."
                            )
                        )
                    }
                }
                .collect { (learnedCount, totalCount, lastLearnedPosition) ->
                    _uiState.update { state ->
                        state.copy(
                            learnedSentenceCount = learnedCount,
                            totalSentenceCount = totalCount,
                            lastLearnedSentencePosition = lastLearnedPosition
                        )
                    }
                }
        }
    }

    fun startLearningSession(requestedCount: Int) {
        if (requestedCount !in SESSION_SIZES) return
        val currentState = _uiState.value
        if (currentState.screen == LearningScreen.PRACTICE ||
            currentState.practice?.isLoading == true
        ) {
            return
        }

        _uiState.update { state ->
            state.copy(
                screen = LearningScreen.PRACTICE,
                practice = PracticeUiState(isLoading = true)
            )
        }

        viewModelScope.launch {
            runCatching {
                repository.getNextUnlearnedSentences(requestedCount)
            }.onSuccess { sentences ->
                _uiState.update { state ->
                    state.copy(
                        practice = PracticeUiState(
                            sentences = sentences,
                            isLoading = false,
                            errorMessage = if (sentences.isEmpty()) {
                                "Yangi gaplar qolmagan."
                            } else {
                                null
                            }
                        )
                    )
                }
            }.onFailure { error ->
                _uiState.update { state ->
                    state.copy(
                        practice = PracticeUiState(
                            isLoading = false,
                            errorMessage = error.message ?: "Yangi gaplarni yuklab bo‘lmadi."
                        )
                    )
                }
            }
        }
    }

    fun markSentenceLearned() {
        val practice = _uiState.value.practice ?: return
        if (practice.phase != PracticePhase.LEARNING || practice.isActionInProgress) return
        val sentence = practice.sentence ?: return

        _uiState.update { state ->
            val currentPractice = state.practice
            if (state.screen != LearningScreen.PRACTICE ||
                currentPractice == null ||
                currentPractice.phase != PracticePhase.LEARNING ||
                currentPractice.sentence?.id != sentence.id ||
                currentPractice.isActionInProgress
            ) {
                state
            } else {
                state.copy(
                    practice = currentPractice.copy(isActionInProgress = true)
                )
            }
        }

        viewModelScope.launch {
            runCatching {
                repository.incrementAcquaintance(sentence.id)
            }.onSuccess {
                _uiState.update { state ->
                    val currentPractice = state.practice
                    if (currentPractice == null ||
                        currentPractice.phase != PracticePhase.LEARNING ||
                        currentPractice.sentence?.id != sentence.id
                    ) {
                        state
                    } else if (currentPractice.sentenceIndex < currentPractice.sentences.lastIndex) {
                        state.copy(
                            practice = currentPractice.copy(
                                sentenceIndex = currentPractice.sentenceIndex + 1,
                                isActionInProgress = false
                            )
                        )
                    } else {
                        state.copy(
                            practice = currentPractice.copy(
                                phase = PracticePhase.SPEAKING,
                                sentenceIndex = 0,
                                speakingTranscript = "",
                                speakingStatus = "Moonshine tayyorlanmoqda...",
                                isActionInProgress = false
                            )
                        )
                    }
                }
            }.onFailure { error ->
                _uiState.update { state ->
                    state.copy(
                        practice = state.practice?.copy(
                            isActionInProgress = false,
                            errorMessage = error.message ?: "Gapni saqlab bo‘lmadi."
                        )
                    )
                }
            }
        }
    }

    fun setSpeakingStatus(status: String) {
        _uiState.update { state ->
            val practice = state.practice
            if (practice == null || practice.phase != PracticePhase.SPEAKING) {
                state
            } else {
                state.copy(practice = practice.copy(speakingStatus = status))
            }
        }
    }

    fun clearLearnedProgress() {
        if (!clearProgressInProgress.compareAndSet(false, true)) return
        viewModelScope.launch {
            try {
                repository.clearLearnedProgress()
            } finally {
                clearProgressInProgress.set(false)
            }
        }
    }

    fun submitSpeakingTranscript(transcript: String) {
        val practice = _uiState.value.practice ?: return
        if (practice.phase != PracticePhase.SPEAKING) return
        val sentence = practice.sentence ?: return
        val cleanedTranscript = transcript.trim()

        if (cleanedTranscript.isBlank()) {
            setSpeakingStatus("Ovoz aniqlanmadi. Qayta urinib ko‘ring.")
            return
        }

        if (normalizeForComparison(cleanedTranscript) != normalizeForComparison(sentence.english)) {
            _uiState.update { state ->
                state.copy(
                    practice = practice.copy(
                        speakingTranscript = cleanedTranscript,
                        speakingStatus = if (practice.isSpeakingAnswerCorrect) {
                            "Qayta urinish to‘g‘ri chiqmadi. Next bilan davom etishingiz yoki yana urinishingiz mumkin."
                        } else {
                            "To‘g‘ri chiqmadi. Shu gapni yana takrorlang."
                        }
                    )
                )
            }
            return
        }

        _uiState.update { state ->
            state.copy(
                practice = practice.copy(
                    speakingTranscript = cleanedTranscript,
                    speakingStatus = "To‘g‘ri. Keyingi gap uchun Next tugmasini bosing.",
                    isSpeakingAnswerCorrect = true
                )
            )
        }
    }

    fun nextSpeakingSentence() {
        val practice = _uiState.value.practice ?: return
        if (practice.phase != PracticePhase.SPEAKING || !practice.isSpeakingAnswerCorrect) {
            return
        }

        if (practice.sentenceIndex < practice.sentences.lastIndex) {
            _uiState.update { state ->
                state.copy(
                    practice = practice.copy(
                        sentenceIndex = practice.sentenceIndex + 1,
                        speakingTranscript = "",
                        speakingStatus = "Keyingi gapni ayting.",
                        isSpeakingAnswerCorrect = false
                    )
                )
            }
        } else {
            startTest(practice)
        }
    }

    private fun startTest(practice: PracticeUiState) {
        val testPractice = practice.copy(
            phase = PracticePhase.TEST,
            sentenceIndex = 0,
            speakingTranscript = "",
            speakingStatus = "",
            testOptions = emptyList(),
            selectedTestAnswer = null,
            isTestAnswerCorrect = null,
            testScore = 0
        )
        _uiState.update { state ->
            state.copy(practice = testPractice)
        }
        loadTestOptions()
    }

    private fun loadTestOptions() {
        val currentState = _uiState.value
        val practice = currentState.practice ?: return
        if (practice.phase != PracticePhase.TEST) return
        val sentence = practice.sentence ?: return

        viewModelScope.launch {
            val candidates = repository.getSimilarDistractorCandidates(sentence.id, limit = 80)
            val fallbackCandidates = practice.sentences
                .filter { it.id != sentence.id }
            val targetText = normalizeForComparison(sentence.english)
            val distractors = (candidates + fallbackCandidates)
                .filter { normalizeForComparison(it.english) != targetText }
                .distinctBy { normalizeForComparison(it.english) }
                .sortedByDescending { distractorSimilarityScore(sentence, it) }
                .take(3)
            val options = (listOf(sentence.english) + distractors.map { it.english })
                .distinct()
                .take(4)
                .shuffled()

            _uiState.update { state ->
                val currentPractice = state.practice
                if (currentPractice == null ||
                    currentPractice.phase != PracticePhase.TEST ||
                    currentPractice.sentence?.id != sentence.id
                ) {
                    state
                } else {
                    state.copy(practice = currentPractice.copy(testOptions = options))
                }
            }
        }
    }

    fun selectTestAnswer(answer: String) {
        val practice = _uiState.value.practice ?: return
        if (practice.phase != PracticePhase.TEST || practice.isTestAnswerCorrect == true) return
        val sentence = practice.sentence ?: return
        val isCorrect = normalizeForComparison(answer) == normalizeForComparison(sentence.english)

        _uiState.update { state ->
            state.copy(
                practice = practice.copy(
                    selectedTestAnswer = answer,
                    isTestAnswerCorrect = isCorrect,
                    testScore = if (isCorrect) practice.testScore + 1 else practice.testScore
                )
            )
        }
    }

    fun nextTestQuestion() {
        val practice = _uiState.value.practice ?: return
        if (practice.phase != PracticePhase.TEST || practice.isTestAnswerCorrect != true) return

        if (practice.sentenceIndex < practice.sentences.lastIndex) {
            _uiState.update { state ->
                state.copy(
                    practice = practice.copy(
                        sentenceIndex = practice.sentenceIndex + 1,
                        testOptions = emptyList(),
                        selectedTestAnswer = null,
                        isTestAnswerCorrect = null
                    )
                )
            }
            loadTestOptions()
        } else {
            backToList()
        }
    }

    fun backToList() {
        _uiState.update { state ->
            state.copy(
                screen = LearningScreen.LIST,
                practice = null
            )
        }
    }

    private fun distractorSimilarityScore(target: Sentence, candidate: Sentence): Int {
        val targetWords = meaningfulEnglishWords(target.english)
        val candidateWords = meaningfulEnglishWords(candidate.english)
        val sharedWords = targetWords.intersect(candidateWords).size
        val wordCountDifference = abs(targetWords.size - candidateWords.size)
        val characterCountDifference = abs(target.english.length - candidate.english.length)
        return (sharedWords * 1000) - (wordCountDifference * 20) - characterCountDifference
    }

    private fun meaningfulEnglishWords(value: String): Set<String> =
        normalizeForComparison(value)
            .split(" ")
            .filter { it.length > 1 && it !in TEST_STOP_WORDS }
            .toSet()

    private fun normalizeForComparison(value: String): String =
        value
            .lowercase()
            .replace(Regex("[^a-z0-9']+"), " ")
            .trim()
            .replace(Regex("\\s+"), " ")
}

