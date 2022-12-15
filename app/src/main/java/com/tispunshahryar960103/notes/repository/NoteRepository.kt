package com.tispunshahryar960103.notes.repository

import com.tispunshahryar960103.notes.data.NoteDAO
import com.tispunshahryar960103.notes.model.Note
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NoteRepository  @Inject constructor(private val noteDAO: NoteDAO){

    suspend fun getAllNotes() = flow {
        val notes = noteDAO.getAllNotes()
        emit(notes)
    }

    suspend fun addNote(note:Note){
        noteDAO.addNote(note = note)
    }








}