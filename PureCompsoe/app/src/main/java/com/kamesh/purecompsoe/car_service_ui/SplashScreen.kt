package com.kamesh.purecompsoe.car_service_ui

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kamesh.purecompsoe.R


@Preview(showBackground = true)
@Composable
fun SplashScreen() {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Lets Get Start")
        }
    }
}