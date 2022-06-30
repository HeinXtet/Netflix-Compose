package com.dee.netflix.ui.appbottombar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dee.common.theme.lightGray
import com.dee.common.theme.white
import com.dee.netflix.navigation.AppBottomNavRoute
import com.dee.netflix.navigation.AppBottomNavRoute.BottomNavScreen
import com.dee.netflix.ui.game.GameScreen
import com.dee.netflix.ui.home.HomeScreen


@Composable
fun AppBottomNavBarScreen() {
    val items = listOf(
        BottomNavScreen.Home,
        BottomNavScreen.Games,
        BottomNavScreen.NewAndHot,
        BottomNavScreen.Download,
    )
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    val isSameRoute =
                        currentDestination?.hierarchy?.any { it.route == screen.route } == true
                    val color = if (!isSameRoute) lightGray else white
                    BottomNavigationItem(
                        icon = {
                            Image(
                                painter = painterResource(id = screen.icon),
                                contentDescription = "Icon For Route",
                                colorFilter = ColorFilter.tint(color)
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = screen.resId),
                                style = MaterialTheme.typography.body2.copy(
                                    color = color
                                ),
                            )
                        },
                        selected = isSameRoute,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = BottomNavScreen.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(BottomNavScreen.Home.route) {
                HomeScreen(hiltViewModel())
            }
            composable(AppBottomNavRoute.BottomNavScreen.Games.route) {
                GameScreen(hiltViewModel())
            }
            composable(AppBottomNavRoute.BottomNavScreen.NewAndHot.route) {
                Text("it is home2 page")
            }
            composable(AppBottomNavRoute.BottomNavScreen.Download.route) {
                Text("it is home2 page")
            }
        }
    }
}