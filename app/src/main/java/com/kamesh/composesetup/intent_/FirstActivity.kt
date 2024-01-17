package com.kamesh.composesetup.intent_

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kamesh.composesetup.R
import com.kamesh.composesetup.ui.theme.ComposeSetupTheme

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSetupTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    Column (modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center){
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                Intent(applicationContext, SecondActivity::class.java).also {it ->
                                    startActivity(it)
                                }
                            }){
                            Text("Go To Second Activity")
                        }

                        Spacer(modifier = Modifier.height(10.dp))


                        /** Explicit Intent
                         * Intent Will perform the Main Action
                         * It open the main activity of package */
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                Intent(Intent.ACTION_MAIN).also {
                                    it.`package` = "com.google.android.youtube"

                                    startActivity(it)
                                }
                            }
                        ){
                            Text("Go To Main Action")
                        }

                        Spacer(modifier = Modifier.height(10.dp))


                        Button(modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                var i = Intent(Intent.ACTION_SEND).apply {
                                    type = "text/plain"
                                    putExtra(Intent.EXTRA_EMAIL,"k@gmail.com")
                                    putExtra(Intent.EXTRA_SUBJECT,"chalo g")
                                    putExtra(Intent.EXTRA_TEXT,"this is message")
                                }

                               if(i.resolveActivity(packageManager) != null){
                                   startActivity(i)
                               }

                            }){
                            Text("Go To Send Mail")
                        }

                    }
                }

            }
        }

    }

    /** activity will not destroy but it will be just perform onNewIntent and inside the intent data
     * will be there*/
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        var uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableExtra(Intent.EXTRA_STREAM,Uri::class.java)
        } else {
            intent?.getParcelableExtra(Intent.EXTRA_STREAM)
        }
    }
}