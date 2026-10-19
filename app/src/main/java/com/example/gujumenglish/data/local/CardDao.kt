package com.example.gujumenglish.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {
    @Query("SELECT * FROM cards WHERE lessonId = :lessonId ORDER BY id ASC")
    fun getCardsByLesson(lessonId: Int): Flow<List<CardEntity>>

    @Query("SELECT * FROM cards ORDER BY lessonId ASC, id ASC")
    fun getAllCards(): Flow<List<CardEntity>>

    @Query("SELECT COUNT(*) FROM cards")
    suspend fun getCardCount(): Int

    @Query("SELECT * FROM cards ORDER BY lessonId ASC, id ASC")
    suspend fun getAllCardsOnce(): List<CardEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCards(cards: List<CardEntity>)

    @Insert
    suspend fun insertUserState(state: CardUserState)

    @Update
    suspend fun updateUserState(state: CardUserState)

    @Query("SELECT * FROM user_cards WHERE userId = :userId AND cardId = :cardId")
    suspend fun getUserState(userId: Int, cardId: String): CardUserState?

    @Query("SELECT * FROM user_cards WHERE userId = :userId AND state != 'locked'")
    suspend fun getActiveUserStates(userId: Int): List<CardUserState>

    @Query("SELECT * FROM user_cards WHERE userId = :userId AND due <= :now ORDER BY due ASC")
    suspend fun getDueCards(userId: Int, now: Long): List<CardUserState>

    @Insert
    suspend fun insertReviewLog(log: ReviewLog)
}
