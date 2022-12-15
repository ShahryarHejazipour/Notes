package com.tispunshahryar960103.notes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    val noteId: Int,

    val subject: String,

    val text: String,

    val time: String,

    val date: String,
)
