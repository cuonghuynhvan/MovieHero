package com.cuong.moviehero.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cuong.moviehero.ui.modules.common.UIEventMessageType

@Composable
fun SnackbarInfoHostState(
    modifier: Modifier = Modifier,
    hostState: AppSnackbarHostState,
) {
    AppSnackbarHost(
        modifier = modifier,
        hostState = hostState,
        snackbar = {
            val data = it as SnackbarDataImpl

            Column(modifier = Modifier.padding(16.dp).statusBarsPadding()) {
                SnackbarMessage(
                    type = data.type,
                    message = data.message,
                )
            }
        }
    )
}

@Composable
fun ProvideSnackbarManager(
    content: @Composable () -> Unit
) {
    val snackbarHostState = remember { AppSnackbarHostState() }
    val snackbarManager = remember { SnackbarManagerImpl(snackbarHostState) }

    CompositionLocalProvider(LocalSnackbarManager provides snackbarManager) {
        content()
    }
    SnackbarInfoHostState(hostState = snackbarHostState)
}

interface SnackbarManager {
    suspend fun show(
        message: String,
        type: UIEventMessageType = UIEventMessageType.ERROR,
    )
}

class EmptySnackbarManager : SnackbarManager {
    override suspend fun show(
        message: String,
        type: UIEventMessageType,
    ) {}
}

class SnackbarManagerImpl(private val snackbarHostState: AppSnackbarHostState) : SnackbarManager {
    override suspend fun show(
        message: String,
        type: UIEventMessageType,
    ) {
        snackbarHostState.showSnackbar(
            type = type,
            message = message,
        )
    }
}

val LocalSnackbarManager = staticCompositionLocalOf<SnackbarManager> { EmptySnackbarManager() }