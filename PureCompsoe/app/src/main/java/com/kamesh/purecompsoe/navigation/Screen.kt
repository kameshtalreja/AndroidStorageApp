package com.kamesh.purecompsoe.navigation



const val ARG_ID = "id"
const val ARG_NAME = "name"
const val ARG_CUSTOM = "custom"

const val ROOT_GRAPH_ROUTE = "root_route"
const val HOME_GRAPH_ROUTE = "home_graph_route"
const val AUTH_GRAPH_ROUTE = "auth_graph_route"

sealed class Screen(val route : String) {

    object Home : Screen(route = "home_screen")
//    object Detail : Screen(route = "detail_screen/{$ARG_ID}/{$ARG_NAME}") {
    object Detail : Screen(route = "detail_screen/{$ARG_CUSTOM}}") {
        fun passId(id : Int) : String{
            return route.replace("{$ARG_ID}",id.toString())
        }

        fun passNameAndId(name : String, id : Int) : String{
            return route.replace("{$ARG_ID}",id.toString()).replace("{$ARG_NAME}",name)
//            return "detail_screen/$id/$name"
        }
        fun passCustomObject(customObject: CustomObject) : String{
            return route.replace("{$ARG_CUSTOM}",customObject.toString())
        }
    }
    object DetailOptional : Screen(route = "detail_optional_screen?id={$ARG_ID}&name={$ARG_NAME}") {

        fun passId(id : Int) : String{
            return route.replace("{$ARG_ID}",id.toString())
        }

        fun passNameAndId(name : String,id : Int) : String{
            return route.replace("{$ARG_ID}",id.toString()).replace("{$ARG_NAME}",name.toString())
        }
    }

    object Login : Screen(route = "login_screen")

    object Register : Screen(route = "register_Screen")
}