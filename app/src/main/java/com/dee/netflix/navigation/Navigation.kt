package com.dee.netflix.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.dee.netflix.R
import com.dee.netflix.navigation.AppGraph.APP
import com.dee.netflix.navigation.AppGraph.AUTH
import com.dee.netflix.navigation.AppRoute.HOME_SCREEN
import com.dee.netflix.navigation.AppRoute.NAV_BOTTOM_DOWNLOAD_SCREEN
import com.dee.netflix.navigation.AppRoute.NAV_BOTTOM_GAME_SCREEN
import com.dee.netflix.navigation.AppRoute.NAV_BOTTOM_HOME_SCREEN
import com.dee.netflix.navigation.AppRoute.NAV_BOTTOM_NEW_HOT_SCREEN
import com.dee.netflix.navigation.AppRoute.SPLASH_SCREEN
import com.dee.netflix.ui.appbottombar.AppBottomNavBarScreen
import com.dee.netflix.ui.splash.SplashScreen

object AppGraph {
    const val AUTH = "auth_graph"
    const val APP = "app_graph"
}

object AppRoute {
    const val SPLASH_SCREEN = "splash_screen"
    const val HOME_SCREEN = "home_screen"
    const val NAV_BOTTOM_HOME_SCREEN = "bottom_nav_home_screen"
    const val NAV_BOTTOM_GAME_SCREEN = "bottom_nav_game_screen"
    const val NAV_BOTTOM_NEW_HOT_SCREEN = "bottom_nav_new_hot_screen"
    const val NAV_BOTTOM_DOWNLOAD_SCREEN = "bottom_nav_download_screen"
}

object AppBottomNavRoute {
    sealed class BottomNavScreen(
        val route: String,
        @StringRes val resId: Int,
        @DrawableRes val icon: Int
    ) {
        object Home :
            BottomNavScreen(NAV_BOTTOM_HOME_SCREEN, R.string.home, R.drawable.baseline_home_24)

        object Games : BottomNavScreen(
            NAV_BOTTOM_GAME_SCREEN,
            R.string.games,
            R.drawable.baseline_sports_esports_24
        )

        object NewAndHot :
            BottomNavScreen(
                NAV_BOTTOM_NEW_HOT_SCREEN,
                R.string.new_hot,
                R.drawable.baseline_video_library_24
            )

        object Download : BottomNavScreen(
            NAV_BOTTOM_DOWNLOAD_SCREEN,
            R.string.download,
            R.drawable.outline_downloading_24
        )
    }
}

object Navigation {
    private fun NavGraphBuilder.authGraph(navController: NavController) {
        navigation(startDestination = HOME_SCREEN, route = APP) {
            composable(HOME_SCREEN) { AppBottomNavBarScreen() }
        }
    }

    private fun NavGraphBuilder.appGraph(navController: NavController) {
        navigation(startDestination = SPLASH_SCREEN, route = AUTH) {
            composable(SPLASH_SCREEN) { SplashScreen(navController) }
        }
    }

    @Composable
    fun AppNavigationGraph(navController: NavHostController) {
        NavHost(navController = navController, startDestination = AUTH) {
            appGraph(navController)
            authGraph(navController)
        }
    }
}