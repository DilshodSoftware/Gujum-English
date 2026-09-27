package com.example.gujumenglish.data

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.gujumenglish.data.local.DictionaryDatabase
import com.example.gujumenglish.data.local.DictionaryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class LearningRepository(context: Context) {
    private val dictionaryDao = DictionaryDatabase
        .getInstance(context)
        .dictionaryDao()

    fun sentencePagingFlow(): Flow<PagingData<Sentence>> = sentencePagingSourceFlow {
        dictionaryDao.pagingSource()
    }

    fun learnedSentencePagingFlow(): Flow<PagingData<Sentence>> = sentencePagingSourceFlow {
        dictionaryDao.learnedPagingSource()
    }

    fun unlearnedSentencePagingFlow(): Flow<PagingData<Sentence>> = sentencePagingSourceFlow {
        dictionaryDao.unlearnedPagingSource()
    }

    private fun sentencePagingSourceFlow(
        pagingSourceFactory: () -> androidx.paging.PagingSource<Int, DictionaryEntity>
    ): Flow<PagingData<Sentence>> = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = PREFETCH_DISTANCE,
            maxSize = MAX_CACHED_ITEMS,
            enablePlaceholders = true
        ),
        pagingSourceFactory = pagingSourceFactory
    ).flow
        .map { pagingData ->
            pagingData.map { entity -> entity.toSentence() }
        }
        .flowOn(Dispatchers.IO)

    suspend fun getNextUnlearnedSentences(limit: Int): List<Sentence> = withContext(Dispatchers.IO) {
        dictionaryDao
            .getNextUnlearnedSentences(limit)
            .map { entity -> entity.toSentence() }
    }

    suspend fun getSimilarDistractorCandidates(
        sentenceId: Int,
        limit: Int
    ): List<Sentence> = withContext(Dispatchers.IO) {
        dictionaryDao
            .getSimilarDistractorCandidates(sentenceId, limit)
            .map { entity -> entity.toSentence() }
    }

    fun observeSentenceCount(): Flow<Int> =
        dictionaryDao.observeSentenceCount().flowOn(Dispatchers.IO)

    fun observeLearnedSentenceCount(): Flow<Int> =
        dictionaryDao.observeLearnedSentenceCount().flowOn(Dispatchers.IO)

    fun observeLastLearnedSentencePosition(): Flow<Int> =
        dictionaryDao.observeLastLearnedSentencePosition().flowOn(Dispatchers.IO)

    suspend fun clearLearnedProgress() = withContext(Dispatchers.IO) {
        dictionaryDao.clearAcquaintance()
    }

    suspend fun incrementAcquaintance(sentenceId: Int) = withContext(Dispatchers.IO) {
        dictionaryDao.incrementAcquaintance(sentenceId)
    }

    private fun DictionaryEntity.toSentence() = Sentence(
        id = id,
        english = sentence,
        uzbek = translation,
        acquaintance = acquaintance
    )

    companion object {
        private const val PAGE_SIZE = 50
        private const val PREFETCH_DISTANCE = 10
        private const val MAX_CACHED_ITEMS = 500
    }
}

data class Sentence(
    val id: Int,
    val english: String,
    val uzbek: String,
    val acquaintance: Int
)
