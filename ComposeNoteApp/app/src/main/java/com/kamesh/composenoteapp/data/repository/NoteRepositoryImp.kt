package com.kamesh.composenoteapp.data.repository

import androidx.lifecycle.LiveData
import com.kamesh.composenoteapp.data.local.room.Note
import com.kamesh.composenoteapp.data.local.room.NoteDao
import com.kamesh.composenoteapp.domain.repository.NoteRepository

class NoteRepositoryImp(private val noteDao : NoteDao) : NoteRepository {

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    override fun getNotes(): LiveData<List<Note>> {
        return noteDao.getNotes()
    }


}