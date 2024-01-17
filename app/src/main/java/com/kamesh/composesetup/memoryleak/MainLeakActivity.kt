package com.kamesh.composesetup.memoryleak

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.kamesh.composesetup.R
import com.kamesh.composesetup.ui.theme.ComposeSetupTheme

class MainLeakActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSetupTheme {
                Column(Modifier.fillMaxSize()) {
                    Button(onClick = {
                        Intent(this@MainLeakActivity,MainLeakActivity2::class.java).also {
                            startActivity(it)
                        }
                    }){
                        Text("Click")
                    }
                }
            }
        }
    }

    companion object {
         var context : Context? = null
    }
}