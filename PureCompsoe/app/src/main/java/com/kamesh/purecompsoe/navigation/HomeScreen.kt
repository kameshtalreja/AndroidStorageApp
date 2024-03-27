package com.kamesh.purecompsoe.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(
    navController: NavHostController
) {

    var detailObject = CustomObject(1,"jhonny",true)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Text(
                text = "Go To Detail",
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
//                navController.navigate("detail_screen/"+1)
//                navController.navigate(Screen.Detail.passId(3))
                    navController.navigate(Screen.Detail.passNameAndId("kamesh",10))
                }
            )
            Text(
                text = "Go To Detail Optional",
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
//                navController.navigate("detail_optional_screen?id=")
//                navController.navigate(Screen.DetailOptional.passId(3))
                    navController.navigate(Screen.DetailOptional.passNameAndId("kamesh",10))
                }
            )
        }

    }
}

@Preview()
@Composable
fun HomeScreenPreview() {

    HomeScreen(navController = rememberNavController())
}