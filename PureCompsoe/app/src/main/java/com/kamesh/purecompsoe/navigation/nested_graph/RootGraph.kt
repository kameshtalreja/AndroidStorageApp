package com.kamesh.purecompsoe.navigation.nested_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kamesh.purecompsoe.navigation.AUTH_GRAPH_ROUTE
import com.kamesh.purecompsoe.navigation.DetailOptionalScreen
import com.kamesh.purecompsoe.navigation.HOME_GRAPH_ROUTE
import com.kamesh.purecompsoe.navigation.HomeScreen
import com.kamesh.purecompsoe.navigation.LoginScreen
import com.kamesh.purecompsoe.navigation.ROOT_GRAPH_ROUTE
import com.kamesh.purecompsoe.navigation.RegisterScreen
import com.kamesh.purecompsoe.navigation.Screen

@Composable
fun SetupRootNavGraph(navController : NavHostController) {

    NavHost(
        navController = navController,
        startDestination = AUTH_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE){


        AuthNavGraph(navController)

        HomeNavGraph(navController)
        
//        navigation(route = AUTH_GRAPH_ROUTE, startDestination = Screen.Login.route){
//
//            composable(Screen.Login.route){
//                LoginScreen(navController = navController)
//            }
//
//            composable(route = Screen.Register.route){
//                RegisterScreen(navController = navController)
//            }
//        }


//        navigation(route = HOME_GRAPH_ROUTE, startDestination = ""){
//
//            composable(Screen.Home.route){
//                HomeScreen(navController = navController)
//            }
//
//            composable(Screen.DetailOptional.route){
//                DetailOptionalScreen(navController = navController)
//            }
//        }
    }
}