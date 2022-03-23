package com.cuong.moviehero.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cuong.moviehero.ui.modules.home.Home
import com.cuong.moviehero.ui.modules.location.Location
import com.cuong.moviehero.ui.modules.movie_detail.MovieDetail

object Routes {
    const val LOCATION_SCREEN = "location"
    const val HOME_SCREEN = "home"
    const val MOVIE_DETAIL_SCREEN = "movie/"
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
                onOpenMovieDetail = {
                    val pathToDetail = "${Routes.MOVIE_DETAIL_SCREEN}${it.id}"
                    navController.navigate(pathToDetail)
                },
            )
        }
        composable(
            "${Routes.MOVIE_DETAIL_SCREEN}{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) {
            MovieDetail(
                movieId = it.arguments?.getString("movieId") ?: "",
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}