package com.kamesh.purecompsoe.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val TAG = "NavGraphTag"
@Composable
fun SetupNavGraph(
     navController : NavHostController
) {


    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(ARG_ID){
                    type = NavType.IntType
                },
                navArgument(ARG_NAME){
                    type = NavType.StringType
                }

            )
        ){
            Log.d(TAG, "Argument : ${it.arguments?.getInt(ARG_ID).toString()}")
            Log.d(TAG, "Arguments Name : ${it.arguments?.getString(ARG_NAME)}")
            DetailScreen(navController = navController)
        }
        composable(
            route = Screen.DetailOptional.route,
            arguments = listOf(
                navArgument(ARG_ID){
                    type = NavType.IntType
                    defaultValue = 10
                },
                navArgument(ARG_NAME){
                    type = NavType.StringType
                    nullable
                }
            )
        ){

            Log.d(TAG, "Optional arguments : ${it.arguments?.getInt(ARG_ID)}")
            Log.d(TAG, "Optional arguments : ${it.arguments?.getString(ARG_NAME)}")

            DetailOptionalScreen(navController = navController)
        }

    }

}