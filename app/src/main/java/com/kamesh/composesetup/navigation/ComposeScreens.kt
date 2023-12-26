package com.kamesh.composesetup.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun ListScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(text = "List Of Options", modifier = Modifier.clickable {
            navController.navigate("detailScreen/"+9)
        })
    }
}

@Composable
fun DetailScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(text = "Details Of Option", modifier = Modifier.clickable {
            navController.popBackStack()
        })
    }
}