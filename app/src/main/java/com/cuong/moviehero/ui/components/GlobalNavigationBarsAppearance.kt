package com.cuong.moviehero.ui.components

import android.view.Window
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.cuong.moviehero.ui.util.findActivity

@Composable
fun GlobalNavigationBarsAppearance(
    isLight: Boolean
) {
    val context = LocalContext.current
    val activity = context.findActivity()
    val window: Window = activity.window
    val windowInsetController = ViewCompat.getWindowInsetsController(window.decorView)

    val openIsLight = remember { windowInsetController?.isAppearanceLightNavigationBars ?: true }

    LaunchedEffect(key1 = isLight) {
        windowInsetController?.isAppearanceLightNavigationBars = isLight
        windowInsetController?.isAppearanceLightStatusBars = isLight
    }

    DisposableEffect(LocalLifecycleOwner.current) {
        onDispose {
            windowInsetController?.isAppearanceLightNavigationBars = openIsLight
            windowInsetController?.isAppearanceLightStatusBars = openIsLight
        }
    }
}