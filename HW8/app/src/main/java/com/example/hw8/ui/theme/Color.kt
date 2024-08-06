package com.example.hw8.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

data class CustomColors(
    val blue: Color = Color(0xFF009DFF),
    val gray: Color = Color(0xFF6D6A6A),
    val lightGray: Color = Color(0xFFD9D9D9),
)

internal val LocalColors = staticCompositionLocalOf { CustomColors() }