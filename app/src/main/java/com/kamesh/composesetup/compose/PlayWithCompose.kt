package com.kamesh.composesetup.compose

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun FirstText() {
    Text(
        "Hello",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Cursive,
        maxLines = 1,
    )
}

@Composable
fun FirstButton() {
    Button(onClick = {
        print("Hello")
    }) {

    }
}

@Composable
fun FirstTextField() {

    val fieldState = remember { mutableStateOf("") }

    TextField(
        value = fieldState.value,
        onValueChange = { it->
            fieldState.value = it
        })
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewT() {
    FirstText()
}