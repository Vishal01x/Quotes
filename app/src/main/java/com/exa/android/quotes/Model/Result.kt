package com.exa.android.quotes.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class Result(
    @PrimaryKey (autoGenerate = true)
    val id : Int,
    val _id: String,
    val author: String,
    val authorSlug: String,
    @ColumnInfo("content") val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    val tags: List<String>
)