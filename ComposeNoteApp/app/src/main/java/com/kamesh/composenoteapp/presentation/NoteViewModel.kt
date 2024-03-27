package com.kamesh.composenoteapp.presentation

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.room.Room
import com.kamesh.composenoteapp.data.local.room.Note
import com.kamesh.composenoteapp.data.local.room.NoteDatabase
import com.kamesh.composenoteapp.data.repository.NoteRepositoryImp
import com.kamesh.composenoteapp.domain.repository.NoteRepository
import kotlinx.coroutines.launch


//class NoteViewModelArg(
//    private val noteRepository: NoteRepository
//) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return   NoteViewModel(noteRepository) as T
//    }
//
//}
class NoteViewModel(
    val noteRepository: NoteRepository
) : ViewModel() {



    val _noteList = MutableLiveData<List<Note>>(emptyList())
    val noteList : LiveData<List<Note>> get() = noteRepository.getNotes()

    val stringList = MutableLiveData<List<String>>(emptyList())


    init {
//        getNotes()
    }

    fun insertNote(note: Note){

        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    }

    fun updateNote(note: Note){
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }
    fun getNotes(){

//        _noteList.value = noteRepository.getNotes()

    }
}