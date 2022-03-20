package com.cuong.moviehero.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cuong.moviehero.ui.modules.location.Location

object Routes {
    const val LOCATION_SCREEN = "location"
}

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Routes.LOCATION_SCREEN
    ) {
        composable(Routes.LOCATION_SCREEN) {
            Location()
        }
    }
}