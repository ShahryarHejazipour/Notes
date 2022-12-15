package com.tispunshahryar960103.notes.screens.noteScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tispunshahryar960103.notes.model.Note
import com.tispunshahryar960103.notes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private var noteRepository: NoteRepository) : ViewModel() {


    fun insertNote(note: Note){
        viewModelScope.launch {
            noteRepository.addNote(note = note)
        }
    }






}