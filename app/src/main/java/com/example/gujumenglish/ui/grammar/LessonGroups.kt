package com.example.gujumenglish.ui.grammar

import android.content.Context
import org.json.JSONObject

/**
 * Darslar bo'limlarining 4-darajali to'plamlarga guruhlangan ro'yxati.
 *
 * Ma'lumot `assets/grammar/groups.json` faylida:
 *   { "target": 4.0,
 *     "groups": [ { "group": 1, "difficulty": 3.97,
 *                   "sections": [ { "lesson": 1, "title": "...", "difficulty": 2.0 } ] } ] }
 *
 * Har bir to'plamning o'rtacha qiyinligi 4.0 ga yaqin bo'lishi uchun to'plamlar
 * aralashtirilgan: oson va qiyin bo'limlar muvozanatlanadi.
 */
object LessonGroups {

    data class Section(
        val lesson: Int,
        val title: String,
        val difficulty: Float
    )

    data class Group(
        val number: Int,
        val difficulty: Float,
        val sections: List<Section>
    )

    private var cache: List<Group> = emptyList()
    private var loaded = false

    fun load(context: Context): List<Group> {
        if (loaded) return cache
        loaded = true
        cache = runCatching {
            val text = context.assets.open("grammar/groups.json")
                .bufferedReader().use { it.readText() }
            val root = JSONObject(text)
            val arr = root.getJSONArray("groups")
            buildList {
                for (i in 0 until arr.length()) {
                    val g = arr.getJSONObject(i)
                    val secs = g.getJSONArray("sections")
                    val sections = buildList {
                        for (j in 0 until secs.length()) {
                            val s = secs.getJSONObject(j)
                            add(
                                Section(
                                    lesson = s.getInt("lesson"),
                                    title = s.getString("title"),
                                    difficulty = s.getDouble("difficulty").toFloat()
                                )
                            )
                        }
                    }
                    add(
                        Group(
                            number = g.getInt("group"),
                            difficulty = g.getDouble("difficulty").toFloat(),
                            sections = sections
                        )
                    )
                }
            }
        }.getOrDefault(emptyList())
        return cache
    }

    /** Dars qaysi to'plamlarga kiradi (bo'limlari bo'yicha). */
    fun groupsOfLesson(context: Context, lesson: Int): List<Group> =
        load(context).filter { g -> g.sections.any { it.lesson == lesson } }
}
