package com.cuong.moviehero.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cuong.moviehero.ui.modules.home.Home
import com.cuong.moviehero.ui.modules.location.Location
import com.cuong.moviehero.ui.modules.movie_detail.MovieDetail

object Routes {
    const val LOCATION_SCREEN = "location"
    const val HOME_SCREEN = "home"
    const val MOVIE_DETAIL_SCREEN = "movie-detail"
}

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME_SCREEN
    ) {
        composable(Routes.LOCATION_SCREEN) {
            Location(
                onOpenHomePage = { navController.navigate(Routes.HOME_SCREEN) }
            )
        }
        composable(Routes.HOME_SCREEN) {
            Home(
                onOpenMovieDetail = { navController.navigate(Routes.MOVIE_DETAIL_SCREEN) }
            )
        }
        composable(Routes.MOVIE_DETAIL_SCREEN) {
            MovieDetail(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}