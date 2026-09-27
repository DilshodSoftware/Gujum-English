package com.example.gujumenglish.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DictionaryDao {
    @Query("SELECT * FROM dictionary ORDER BY id ASC")
    fun pagingSource(): PagingSource<Int, DictionaryEntity>

    @Query("SELECT * FROM dictionary WHERE acquaintance > 0 ORDER BY id ASC")
    fun learnedPagingSource(): PagingSource<Int, DictionaryEntity>

    @Query("SELECT * FROM dictionary WHERE acquaintance = 0 ORDER BY id ASC")
    fun unlearnedPagingSource(): PagingSource<Int, DictionaryEntity>

    @Query("SELECT COUNT(*) FROM dictionary")
    fun observeSentenceCount(): Flow<Int>

    @Query("SELECT COUNT(*) FROM dictionary WHERE acquaintance > 0")
    fun observeLearnedSentenceCount(): Flow<Int>

    @Query(
        "SELECT COUNT(*) FROM dictionary " +
            "WHERE id <= COALESCE(" +
            "(SELECT MAX(id) FROM dictionary WHERE acquaintance > 0), 0)"
    )
    fun observeLastLearnedSentencePosition(): Flow<Int>

    @Query("SELECT * FROM dictionary WHERE acquaintance = 0 ORDER BY id ASC LIMIT :limit")
    suspend fun getNextUnlearnedSentences(limit: Int): List<DictionaryEntity>

    @Query(
        "SELECT * FROM dictionary WHERE id != :sentenceId " +
            "ORDER BY ABS(LENGTH(sentence) - " +
            "(SELECT LENGTH(sentence) FROM dictionary WHERE id = :sentenceId)), RANDOM() " +
            "LIMIT :limit"
    )
    suspend fun getSimilarDistractorCandidates(
        sentenceId: Int,
        limit: Int
    ): List<DictionaryEntity>

    @Query("UPDATE dictionary SET acquaintance = 0")
    suspend fun clearAcquaintance()

    @Query("UPDATE dictionary SET acquaintance = acquaintance + 1 WHERE id = :sentenceId")
    suspend fun incrementAcquaintance(sentenceId: Int)
}
