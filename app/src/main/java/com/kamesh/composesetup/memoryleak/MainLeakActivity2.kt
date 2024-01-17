package com.kamesh.composesetup.memoryleak

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.kamesh.composesetup.R
import com.kamesh.composesetup.ui.theme.ComposeSetupTheme

class MainLeakActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLeakActivity.context = this
            ComposeSetupTheme {
                Column(modifier = Modifier.fillMaxSize().background(Color.Yellow)) {  }
            }
        }
    }


}