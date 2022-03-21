package com.cuong.moviehero.ui.modules.common

import com.cuong.moviehero.R
import com.cuong.moviehero.domain.exception.NetworkConnectionException
import com.cuong.moviehero.domain.exception.GetLocationFailedException
import java.lang.Exception

class ExceptionMessageHandler {
    fun createErrorMessageEvent(exception: Exception): UIEventState =
        when (exception) {
            is NetworkConnectionException -> UIEventState(messageResId = R.string.error_message_network_connection, type = UIEventMessageType.ERROR)
            is GetLocationFailedException -> UIEventState(messageResId = R.string.error_message_cannot_get_location, type = UIEventMessageType.NEUTRAL)
            else -> throw exception
        }
}