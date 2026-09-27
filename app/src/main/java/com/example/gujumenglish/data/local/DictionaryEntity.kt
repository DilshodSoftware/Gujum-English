package com.example.gujumenglish.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dictionary")
data class DictionaryEntity(
    @PrimaryKey
    val id: Int,
    val sentence: String,
    val translation: String,
    @ColumnInfo(name = "acquaintance")
    val acquaintance: Int
)
