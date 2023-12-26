package com.kamesh.composesetup

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun NotificationScreen(){

    val count  = rememberSaveable {  mutableStateOf(0) }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        NotificationCounter(count.value) { count.value++ }
        MessageBar(count.value)

    }
}

@Composable
fun NotificationCounter(count: Int, countIncrement: () -> Unit) {
    Log.d("TAG", "NotificationCounter: recompose")



    Text("the counter is counting ${count}")

    Button(onClick = {

        countIncrement()

    }){
        Text("Increase Counter")
    }

}

@Composable
fun MessageBar(count: Int) {

    Card(
    ) {
        Row (modifier = Modifier.padding(8.dp)){
            Text("Counter Message $count")
        }

    }
}