package com.kamesh.composenoteapp

import android.app.Application
import com.kamesh.composenoteapp.di.composeNoteApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ComposeNoteApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ComposeNoteApp)
            modules(composeNoteApp)
        }
    }
}