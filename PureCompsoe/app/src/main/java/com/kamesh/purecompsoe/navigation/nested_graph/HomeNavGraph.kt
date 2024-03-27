package com.kamesh.purecompsoe.navigation.nested_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kamesh.purecompsoe.navigation.DetailOptionalScreen
import com.kamesh.purecompsoe.navigation.HOME_GRAPH_ROUTE
import com.kamesh.purecompsoe.navigation.HomeScreen
import com.kamesh.purecompsoe.navigation.Screen

fun NavGraphBuilder.HomeNavGraph(
    navController : NavHostController
){
    navigation(route = HOME_GRAPH_ROUTE, startDestination = Screen.Home.route){

        composable(Screen.Home.route){
            HomeScreen(navController = navController)
        }

        composable(Screen.DetailOptional.route){
            DetailOptionalScreen(navController = navController)
        }
    }

}