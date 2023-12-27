package com.kamesh.composesetup

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.kamesh.composesetup.ui.theme.ComposeSetupTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var myString: String
    @Inject @Named("hello1") lateinit var hello1: String
    @Inject @Named("hello2") lateinit var hello2: String
    @Inject @Named("hello3") lateinit var hello3: String
    @Inject @Named("hello4") lateinit var hello4: String


    private  val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            ComposeSetupTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    NotificationScreen()
                    val navController = rememberNavController()

//                    NavGraph(navController)
                    com.kamesh.composesetup.presentation.graph.NavGraph(navController = navController)

                    Log.d(TAG, "onCreate: $myString")
                    Log.d(TAG, "onCreate: $hello1")
                    Log.d(TAG, "onCreate: $hello2")
                    Log.d(TAG, "onCreate: $hello3")
                    Log.d(TAG, "onCreate: $hello4")

                }
            }
            print("message print for commit 2")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeSetupTheme {
        Greeting("Android")
    }
}
