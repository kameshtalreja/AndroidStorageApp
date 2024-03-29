package com.kamesh.androidstorageapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun MainScreen() {

    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ){
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 100.dp),
        ){
            items(4){
                Image(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = ""
                )
            }

        }

        Row (modifier = Modifier
            .fillMaxWidth()
            ){

            Image(imageVector = Icons.Default.AddCircle, contentDescription = "")

        }
    }
}