package com.tispunshahryar960103.notes.repository

import com.tispunshahryar960103.notes.data.NoteDAO
import com.tispunshahryar960103.notes.model.Note
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NoteDataSource /*@Inject constructor(private val noteDAO: NoteDAO)*/ {

    //emit a Flow of data
 /*   private val refreshInterval : Long = 5000

    val notes : Flow<List<Note>> = flow {

        while (true){
            val notes = noteDAO.getAllNotes()
            emit(notes) // -> emits the result of the request to the flow


        }
    }*/
}

