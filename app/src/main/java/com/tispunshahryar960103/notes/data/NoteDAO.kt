package com.tispunshahryar960103.notes.data

import androidx.room.*
import com.tispunshahryar960103.notes.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDAO {

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes():List<Note>


    @Query("SELECT * FROM notes WHERE subject LIKE :search OR date LIKE :search ")
    suspend fun findNoteBySubjectOrTime(search:String) : Note


    @Insert
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