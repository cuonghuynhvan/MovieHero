package com.cuong.moviehero.ui.modules.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import com.cuong.moviehero.ui.components.LocalSnackbarManager

@Composable
fun ExceptionMessageComposable(
    state: UIEventState = UIEventState(),
) {
    if(state.messageResId == 0) {
        return
    }

    val snackbarManager = LocalSnackbarManager.current
    val message = stringResource(id = state.messageResId)
    LaunchedEffect(key1 =state, block = {
      snackbarManager.show(
          message = message,
          type = state.type,
      )
    })
}