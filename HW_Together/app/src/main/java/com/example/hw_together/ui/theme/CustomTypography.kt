package com.example.hw_together.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class CustomTypography(
    val headerAuthorization: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        fontSize = 28.sp,
        lineHeight = 33.sp,
    ),
    val subHeaderAuthorization: TextStyle = TextStyle(
        fontWeight = FontWeight(400),
        fontFamily = FontFamily.SansSerif,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    ),
    val bodyTextFieldAuthorization: TextStyle = TextStyle(
        fontWeight = FontWeight(600),
        fontFamily = FontFamily.SansSerif,
        fontSize = 12.sp,
        lineHeight = 14.sp,
    ),
    val bodyButtonAuthorization: TextStyle = TextStyle(
        fontWeight = FontWeight(600),
        fontFamily = FontFamily.SansSerif,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    ),
    val titleHeader:TextStyle= TextStyle(
        fontWeight = FontWeight(700),
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        lineHeight = 23.sp
    ),
    val smallBody:TextStyle= TextStyle(
        fontWeight = FontWeight(500),
        fontFamily = FontFamily.SansSerif,
        fontSize = 14.sp,
        lineHeight = 16.sp
    ),
    val littleBody:TextStyle= TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        fontSize = 12.sp,
        lineHeight = 14.sp
    ),
    val bigBody:TextStyle= TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        lineHeight = 28.sp
    ),
    val noteHeader:TextStyle= TextStyle(
        fontWeight = FontWeight(600),
        fontFamily = FontFamily.SansSerif,
        fontSize = 28.sp,
        lineHeight = 23.sp
    ),
)

val LocalTypography = staticCompositionLocalOf { CustomTypography() }