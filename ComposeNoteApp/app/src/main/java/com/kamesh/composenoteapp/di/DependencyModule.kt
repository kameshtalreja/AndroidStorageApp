package com.kamesh.composenoteapp.di

import androidx.room.Room
import com.kamesh.composenoteapp.ComposeNoteApp
import com.kamesh.composenoteapp.data.local.room.NoteDao
import com.kamesh.composenoteapp.data.local.room.NoteDatabase
import com.kamesh.composenoteapp.data.repository.NoteRepositoryImp
import com.kamesh.composenoteapp.domain.repository.NoteRepository
import com.kamesh.composenoteapp.presentation.NoteViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val composeNoteApp = module {

    single <String>{
        "Hello wOrld"
    }
    single <NoteDatabase>{
        Room.databaseBuilder(androidContext(),NoteDatabase::class.java,"noteDatabase").build()
    }

    single <NoteDao>{
        get<NoteDatabase>().getNoteDao()
    }

    single <NoteRepository>{
        NoteRepositoryImp(get())
    }

    viewModel {
        NoteViewModel(get())
    }
}