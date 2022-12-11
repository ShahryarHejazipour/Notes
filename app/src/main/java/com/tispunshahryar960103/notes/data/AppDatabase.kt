package com.tispunshahryar960103.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tispunshahryar960103.notes.model.Note
import com.tispunshahryar960103.notes.model.User

@Database(entities = [Note::class,User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDAO():NoteDAO


}