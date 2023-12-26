package com.kamesh.composesetup.presentation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kamesh.composesetup.presentation.HomeScreen.HomeScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "a"){
        composable(route = "a"){

            HomeScreen()
        }

    }
}