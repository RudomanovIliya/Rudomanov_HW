package com.example.hw_together.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

data class CustomColors(
    val yellow: Color = Color(0xFFFFD80C),
    val transparentBlack: Color = Color(0x33333333),
    val lightBlack: Color = Color(0xFF333333),
    val gray: Color = Color(0xFFD7D7D7),
    val darkGray: Color = Color(0xFF646464),
    val blueLagoon: Color = Color(0xFF806B00),
    val rippleGrayTransparent:Color=Color(0x66D7D7D7)
)

internal val LocalColors = staticCompositionLocalOf { CustomColors() }
