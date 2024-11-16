package com.agrisustain.tugasfrontend_cindy.navigation

sealed class Screen (val route: String){
    object About : Screen("about")
    object List : Screen("list")
    object Grid : Screen("grid")
    object DetailMakeup : Screen("detail_makeup")
}