package com.kamesh.composesetup.patterns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kamesh.composesetup.patterns.ui.theme.ComposeSetupTheme

class PatternActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            ComposeSetupTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column (modifier = Modifier.fillMaxSize()){

                        Button(
                            modifier = Modifier.fillMaxWidth().height(50.dp),
                            onClick = { runObserverPattern() }){
                            Text("Click For Observer Pattern Run")
                        }

                        Button(
                            modifier = Modifier.fillMaxWidth().height(50.dp),
                            onClick = { runAdapterPattern() }){
                            Text("Click For Adapter Pattern Run")
                        }
                    }



                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    ComposeSetupTheme {
        Greeting3("Android")
    }
}