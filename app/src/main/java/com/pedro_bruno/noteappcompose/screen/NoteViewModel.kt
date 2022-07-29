package com.pedro_bruno.noteappcompose.screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro_bruno.noteappcompose.data.NotesDataSource
import com.pedro_bruno.noteappcompose.model.Note
import com.pedro_bruno.noteappcompose.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()
    //private var noteList = mutableStateListOf<Note>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect { listOfNotes ->
                    if (listOfNotes.isNullOrEmpty()) {
                        Log.d("Empty", "Empty list")
                    } else {
                        _noteList.value = listOfNotes
                    }
                }
        }
    }

     fun addNote(note: Note) = viewModelScope.launch {
        repository.addNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }

     fun deleteNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }

     fun deleteAllNotes() = viewModelScope.launch {
        repository.deleteAllNotes()
    }

}