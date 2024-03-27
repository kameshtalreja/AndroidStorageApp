package com.kamesh.composenoteapp.domain.repository

import androidx.lifecycle.LiveData
import com.kamesh.composenoteapp.data.local.room.Note

interface NoteRepository {

    suspend fun insertNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)

    fun getNotes() : LiveData<List<Note>>

}