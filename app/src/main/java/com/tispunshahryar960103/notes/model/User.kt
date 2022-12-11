package com.tispunshahryar960103.notes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    var userId: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "user_name")
    var username: String,
    @ColumnInfo(name = "password")
    var password: String,
    @ColumnInfo(name = "profile_image")
    var profileImage : String
)
