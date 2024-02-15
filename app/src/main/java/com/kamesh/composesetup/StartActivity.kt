package com.kamesh.composesetup

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kamesh.composesetup.compose.ComposableActivity
import com.kamesh.composesetup.ui.theme.ComposeSetupTheme

class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSetupTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Button(onClick = {
                           Intent(applicationContext, ComposableActivity::class.java).also {
                               startActivity(it)
                           }
                        }, modifier = Modifier.fillMaxWidth()){
                            Text("Composable Activity")
                        }

                        Button(onClick = {
                            Intent("CUSTOM_RECEIVER").let { it ->
                                it.putExtra("msg","love you broadcast")
                                sendBroadcast(it)
                            }
                        }){
                            Text("Send Custom Broadcast CS2")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting5(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    ComposeSetupTheme {
        Greeting5("Android")
    }
}