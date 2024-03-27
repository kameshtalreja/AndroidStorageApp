package com.kamesh.purecompsoe.navigation.nested_graph

import android.content.Intent
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.kamesh.purecompsoe.deeplink.DeeplinkCompose
import com.kamesh.purecompsoe.navigation.AUTH_GRAPH_ROUTE
import com.kamesh.purecompsoe.navigation.LoginScreen
import com.kamesh.purecompsoe.navigation.RegisterScreen
import com.kamesh.purecompsoe.navigation.Screen

fun NavGraphBuilder.AuthNavGraph(
    navController : NavHostController
){

    navigation(route = AUTH_GRAPH_ROUTE, startDestination = Screen.Login.route){

        composable(Screen.Login.route){
            LoginScreen(navController = navController)
        }

        composable(route = Screen.Register.route){
            RegisterScreen(navController = navController)
        }

        composable(
            route = "deeplink",
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://kamesh.io/{id}"
//                    uriPattern = "https://github.com/{id}"
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(
                navArgument(name = "id"){
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ){backStack ->
            DeeplinkCompose(backStack.arguments?.getInt("id",))
        }
    }
}