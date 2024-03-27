package com.kamesh.androidstorageapp

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.kamesh.androidstorageapp.ui.theme.AndroidStorageAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidStorageAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    private fun loadImagesFromInternalStorageToList() {
        lifecycleScope.launch {
            val images = loadPhotosFromInternalStorage()

        }
    }

    private fun deletePhotoFromInternalStorage(filename : String) : Boolean {
        return try {
            deleteFile(filename)
        } catch (e : IOException) {
            e.printStackTrace()
            false
        }
    }

    private suspend fun loadPhotosFromInternalStorage() : List<InternalStorageImages> {
        return withContext(Dispatchers.IO){
            val files = filesDir.listFiles()
            files?.filter { it.canRead() && it.isFile && it.name.endsWith(".jpg")}?.map { it ->
                val bytes = it.readBytes()
                val bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.size)
                InternalStorageImages(it.name,bitmap)
            } ?: listOf()
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
    AndroidStorageAppTheme {
        Greeting("Android")
    }
}