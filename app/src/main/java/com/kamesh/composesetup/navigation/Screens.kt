package com.kamesh.composesetup.navigation

sealed class Screens(
    val route : String
) {
    object ListScreen : Screens(route = "listScreen")
    object DetailScreen : Screens(route = "detailScreen/{id}")
}