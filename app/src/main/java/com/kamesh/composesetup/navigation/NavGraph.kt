package com.kamesh.composesetup.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.ListScreen.route){

        composable(route = Screens.ListScreen.route) {
            ListScreen(navController = navController)
        }
        composable(
            route = Screens.DetailScreen.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
                defaultValue = 0
            })
        ) {
            Log.d("TAG", "NavGraph: ${it.arguments?.getInt("id")}")
            DetailScreen(navController = navController)
        }
    }
}