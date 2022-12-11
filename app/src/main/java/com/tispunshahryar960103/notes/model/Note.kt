package com.tispunshahryar960103.notes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    val noteId: String,
    @ColumnInfo(name = "subject")
    val subject: String,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "time")
    val time: String,
    @ColumnInfo(name = "date")
    val date: String,
)
