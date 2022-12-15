package com.tispunshahryar960103.notes.screens.noteListScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tispunshahryar960103.notes.model.Note
import com.tispunshahryar960103.notes.repository.NoteRepository
import com.tispunshahryar960103.notes.utils.DataOrException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(private var noteRepository: NoteRepository) : ViewModel() {


    val data : MutableState<DataOrException<List<Note>,Boolean,Exception>> = mutableStateOf(
        DataOrException(listOf(),true,Exception("")))

    init {

        fetchAllNotes()

    }

    private fun fetchAllNotes(){
        viewModelScope.launch {
            noteRepository.getAllNotes().collect{
                data.value.loading = true
                data.value.data = it
                if (!data.value.data.isNullOrEmpty()) data.value.loading = false
            }
        }
    }












}