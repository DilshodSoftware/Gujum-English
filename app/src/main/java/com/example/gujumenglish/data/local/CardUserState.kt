package com.example.gujumenglish.data.local

import androidx.room.Entity
import androidx.room.ForeignKey

/**
 * Per-user SRS state for each card.
 */
@Entity(
    tableName = "user_cards",
    primaryKeys = ["userId", "cardId"],
    foreignKeys = [
        ForeignKey(
            entity = CardEntity::class,
            parentColumns = ["id"],
            childColumns = ["cardId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CardUserState(
    val userId: Int = 1, // single-user app for now
    val cardId: String,
    val state: String = "new", // locked | new | learning | review | relearning
    val stability: Double? = null,
    val difficulty: Int? = null,
    val due: Long? = null, // timestamp ms
    val lastReview: Long? = null,
    val reps: Int = 0,
    val lapses: Int = 0
)
