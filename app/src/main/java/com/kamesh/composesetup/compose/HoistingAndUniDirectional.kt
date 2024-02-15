package com.kamesh.composesetup.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun hoistingInCompose(){

    val counter = remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MessageBox(counter.value) { counter.value++ }
        CardMessage(counter.value)
    }

}

@Composable
fun MessageBox(counter: Int, incrementCounter : () -> Unit) {



    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Count is ${counter} ")
        Button(onClick = {  incrementCounter() }){

            Text("Increase count")
        }
    }
}

@Composable
fun CardMessage(value : Int){


    Card(
//        elevation = 4.dp,
        modifier = androidx.compose.ui.Modifier.padding(10.dp)
    ){
        Text("card count is same $value")
    }

}
