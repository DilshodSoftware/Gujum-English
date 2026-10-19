package com.example.gujumenglish.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Card content (static) — one fact per card.
 * Imported from JSON / CSV.
 */
@Entity(tableName = "cards")
data class CardEntity(
    @PrimaryKey
    val id: String, // e.g. "L01-C07"
    val lessonId: Int,
    val type: String, // word | chunk | grammar | translation | listening | speaking
    val prompt: String, // English prompt / question
    val answer: String, // Expected answer (Uzbek translation or English fill-in)
    val audioFile: String?, // relative path or asset name
    val example: String?, // Example sentence / context
    val tags: String, // JSON array as string, e.g. "[\"greeting\",\"question\"]"
    val uzInterference: Boolean = false // tag for Uzbek-specific interference cards
)
