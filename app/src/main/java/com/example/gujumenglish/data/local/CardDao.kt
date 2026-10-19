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
    suspend fun getCardsByLessonOnce(lessonId: Int): List<CardEntity>

    @Query("SELECT cardId FROM user_cards WHERE state = 'locked' AND cardId IN (:cardIds)")
    suspend fun getLockedCardIds(cardIds: List<String>): List<String>

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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUserStates(states: List<CardUserState>)

    @Update
    suspend fun updateUserState(state: CardUserState)

    @Query("SELECT * FROM user_cards WHERE userId = :userId AND cardId = :cardId")
    suspend fun getUserState(userId: Int, cardId: String): CardUserState?

    @Query("SELECT * FROM user_cards WHERE userId = :userId AND state != 'locked'")
    suspend fun getActiveUserStates(userId: Int): List<CardUserState>

    /** Darsni o'zgartirish: kartalarni locked/unlocked qilish. */
    @Query("UPDATE user_cards SET state = :state WHERE cardId IN (:cardIds)")
    suspend fun setStateForCards(cardIds: List<String>, state: String)

    @Query("SELECT * FROM user_cards WHERE userId = :userId AND due <= :now ORDER BY due ASC")
    suspend fun getDueCards(userId: Int, now: Long): List<CardUserState>

    @Insert
    suspend fun insertReviewLog(log: ReviewLog)
}
