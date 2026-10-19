package com.example.gujumenglish.data.local

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray

/**
 * Card content import from JSON asset.
 */
object CardContentImporter {

    suspend fun importIfEmpty(context: Context, database: CardDatabase) = withContext(Dispatchers.IO) {
        val dao = database.cardDao()
        // Real empty check: skip when cards already imported (avoids PK conflict).
        if (dao.getCardCount() > 0) return@withContext

        val assetText = try {
            context.assets.open("cards_content.json").bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            null
        }

        if (!assetText.isNullOrBlank()) {
            val array = JSONArray(assetText)
            val cards = ArrayList<CardEntity>(array.length())
            for (i in 0 until array.length()) {
                val o = array.getJSONObject(i)
                cards.add(
                    CardEntity(
                        id = o.getString("id"),
                        lessonId = o.getInt("lessonId"),
                        type = o.getString("type"),
                        prompt = o.getString("prompt"),
                        answer = o.getString("answer"),
                        audioFile = o.optString("audioFile", null),
                        example = o.optString("example", null),
                        tags = o.optString("tags", "[]").let {
                            if (it.isBlank() || it.trim() == "[]") "[]" else it.trim()
                        },
                        uzInterference = o.optBoolean("uzInterference", false)
                    )
                )
            }

            // Simple insert; in real app check duplicates
            dao.insertCards(cards)
        }
    }
}
