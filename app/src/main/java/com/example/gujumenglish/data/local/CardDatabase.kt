package com.example.gujumenglish.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(
    entities = [CardEntity::class, CardUserState::class, ReviewLog::class],
    version = 6,
    exportSchema = false
)
abstract class CardDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao

    companion object {
        @Volatile
        private var instance: CardDatabase? = null

        fun getInstance(context: Context): CardDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    CardDatabase::class.java,
                    "cards.db"
                )
                    // No prepackaged asset: DB is created empty and filled
                    // at runtime from cards_content.json (see CardContentImporter).
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it }
            }
    }
}
