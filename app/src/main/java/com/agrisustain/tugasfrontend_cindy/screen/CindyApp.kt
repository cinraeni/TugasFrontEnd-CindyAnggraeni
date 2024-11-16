package com.agrisustain.tugasfrontend_cindy.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.agrisustain.tugasfrontend_cindy.R
import com.agrisustain.tugasfrontend_cindy.model.Profil
import com.agrisustain.tugasfrontend_cindy.navigation.NavigationItem
import com.agrisustain.tugasfrontend_cindy.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CindyApp (
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Tugas Frontend Cindy") },
                actions = {
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFFFC1C1))
            )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.About.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.About.route) {
                AboutScreen(
                    profil = Profil(
                        1,
                        "Cindy Anggraeni",
                        "Politeknik Negeri Batam",
                        "Teknik Informatika",
                        "cindyanggraeni133@gmail.com",
                        R.drawable.profil
                    ),
                    navController = NavController(context)
                )
            }

            composable(Screen.List.route) {
                ListScreen(navController)
            }

            composable(Screen.Grid.route) {
                GridScreen(navController)
            }

            composable(
                Screen.DetailMakeup.route + "/{makeupid}",
                arguments = listOf(navArgument("makeupid") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailMakeupScreen(
                    navController = navController,
                    makeupid = navBackStackEntry.arguments?.getInt("makeupid")
                )
            }
        }
    }
}

@Composable
private fun BottomBar (
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar (
        modifier = Modifier,
        containerColor = Color(0xFFFFC1C1)
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_about),
                icon = Icons.Default.Home,
                screen = Screen.About
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_list),
                icon = Icons.AutoMirrored.Filled.List,
                screen = Screen.List
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_grid),
                icon = Icons.AutoMirrored.Filled.List,
                screen = Screen.Grid
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewBottomBar () {
    CindyApp()
//    BottomBar(navController = rememberNavController())
}