package com.cuong.moviehero.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.cuong.moviehero.ui.theme.MovieHeroTheme

@Composable
fun MovieHeroApp() {
    MovieHeroTheme(
        darkTheme = false,
    ) {
        val navController = rememberNavController()
        Surface(color = MaterialTheme.colors.background) {
            NavGraph(navController)
        }
    }
}