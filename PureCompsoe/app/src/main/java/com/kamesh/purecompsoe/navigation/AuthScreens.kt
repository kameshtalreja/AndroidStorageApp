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
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(
    navController : NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {

        Column {
            Text(
                text = "Login Screen",
                color = MaterialTheme.colorScheme.error,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate(HOME_GRAPH_ROUTE){
                        popUpTo(Screen.Home.route){
                            inclusive = true
                        }
                    }
                }
            )
            Text(
                text = "Deeplink Screen",
                color = MaterialTheme.colorScheme.error,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate("deeplink")
                }
            )
        }

    }
}

@Composable
fun RegisterScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Text(
            text = "Login Screen",
            color = MaterialTheme.colorScheme.error,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                navController.navigate(Screen.Home.route){
                    popUpTo(Screen.Home.route){
                        inclusive = true
                    }
                }
            }
        )
    }
}