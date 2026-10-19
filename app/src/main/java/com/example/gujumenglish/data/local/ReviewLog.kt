package com.example.gujumenglish.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Append-only review logs, needed for FSRS optimization.
 */
@Entity(tableName = "review_logs")
data class ReviewLog(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: Int = 1,
    val cardId: String,
    val grade: Int, // 1=Again, 2=Hard, 3=Good, 4=Easy
    val reviewedAt: Long, // timestamp ms
    val elapsedDays: Int,
    val responseTimeMs: Long,
    val prevStability: Double?,
    val prevDifficulty: Int?
)
