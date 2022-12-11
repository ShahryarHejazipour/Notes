package com.tispunshahryar960103.notes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.tispunshahryar960103.notes.model.Note
import com.tispunshahryar960103.notes.model.User


@Dao
interface NoteDAO {

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes():List<Note>

    @Query("SELECT * FROM users")
    suspend fun getAllUsers() : List<User>

    @Query("SELECT * FROM notes WHERE subject LIKE :search OR date LIKE :search ")
    suspend fun findNoteBySubjectOrTime(search:String) : Note


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note:Note)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllNotes(vararg notes: Note)

    @Delete
    suspend fun deleteNote(note:Note)

    @Delete
    suspend fun deleteNotes(vararg notes:Note)

    @Update
    suspend fun updateNote(note: Note)




}