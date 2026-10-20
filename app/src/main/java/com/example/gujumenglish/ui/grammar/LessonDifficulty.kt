package com.example.gujumenglish.ui.grammar

import android.content.Context
import org.json.JSONObject

/**
 * Nazariya darslarining qiyinlik darajasi (0-10).
 *
 * Ma'lumot `assets/grammar/difficulty.json` faylida saqlanadi:
 *   { "lessons": [ { "lesson": 1, "difficulty": 2.0,
 *                    "sections": [ { "title": "...", "difficulty": 3.1 } ] } ] }
 *
 * 0 = umuman qiyin emas ... 10 = juda qiyin.
 */
object LessonDifficulty {

    data class Section(val title: String, val difficulty: Float)

    data class Lesson(
        val lesson: Int,
        val difficulty: Float,
        val sections: List<Section>
    )

    private var cache: Map<Int, Lesson> = emptyMap()
    private var loaded = false

    private fun load(context: Context) {
        if (loaded) return
        loaded = true
        cache = runCatching {
            val text = context.assets.open("grammar/difficulty.json")
                .bufferedReader().use { it.readText() }
            val root = JSONObject(text)
            val arr = root.getJSONArray("lessons")
            buildMap {
                for (i in 0 until arr.length()) {
                    val o = arr.getJSONObject(i)
                    val secs = o.getJSONArray("sections")
                    val sections = buildList {
                        for (j in 0 until secs.length()) {
                            val s = secs.getJSONObject(j)
                            add(
                                Section(
                                    title = s.getString("title"),
                                    difficulty = s.getDouble("difficulty").toFloat()
                                )
                            )
                        }
                    }
                    val number = o.getInt("lesson")
                    // Dars darajasidagi ball: JSON da yo'q bo'lsa bo'limlar
                    // o'rtachasidan hisoblanadi (dars hech qachon ko'rsatilmay qolmasin).
                    val level = if (o.has("difficulty")) {
                        o.getDouble("difficulty").toFloat()
                    } else if (sections.isNotEmpty()) {
                        sections.sumOf { it.difficulty.toDouble() }
                            .toFloat() / sections.size
                    } else {
                        0f
                    }
                    put(number, Lesson(number, level, sections))
                }
            }
        }.getOrDefault(emptyMap())
    }

    /** Dars qiyinlik darajasi (null — ma'lumot yo'q). */
    fun of(context: Context, lesson: Int): Lesson? {
        load(context)
        return cache[lesson]
    }

    /**
     * Qiyinlik uchun rang. Shkala 4.0 markazli kalibrlangan:
     * "oddiy dars" = 4.0 (ko'k), undan yengilroq — yashil/sariq,
     * qiyinroq — to'q sariq/qizil.
     */
    fun colorFor(level: Float): Long = when {
        level < 2.5f -> 0xFF2E7D32L      // yashil  — Oson
        level < 3.5f -> 0xFFF9A825L      // sariq   — O'rtacha
        level < 5.0f -> 0xFF2E7EA3L      // ko'k    — Standart (4.0 markazi)
        level < 6.0f -> 0xFFEF6C00L      // to'q sariq — Qiyin
        else -> 0xFFC62828L              // qizil   — Juda qiyin
    }

    /** Qiyinlik yorlig'i (qisqacha). */
    fun label(level: Float): String = when {
        level < 2.5f -> "Oson"
        level < 3.5f -> "O'rtacha"
        level < 5.0f -> "Standart"
        level < 6.0f -> "Qiyin"
        else -> "Juda qiyin"
    }
}
