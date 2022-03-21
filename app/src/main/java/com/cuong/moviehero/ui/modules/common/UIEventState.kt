package com.cuong.moviehero.ui.modules.common

import java.util.*

data class UIEventState (
    val messageResId: Int = 0,
    val type: UIEventMessageType = UIEventMessageType.NEUTRAL,
    val createTime: Long = Date().time,
)

enum class UIEventMessageType {
    NEUTRAL,
    ERROR,
    SUCCESS,
}

