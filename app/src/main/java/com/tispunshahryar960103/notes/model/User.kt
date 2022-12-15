package com.tispunshahryar960103.notes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    var userId: String,

    var name: String,

    var username: String,

    var password: String,

    var profileImage : String
)
