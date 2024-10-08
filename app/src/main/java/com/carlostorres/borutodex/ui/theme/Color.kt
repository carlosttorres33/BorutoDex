package com.carlostorres.borutodex.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import okhttp3.internal.wait

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)

val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)
val StartColor = Color(0xFFFFC94D)

val ShimmerLightGray = Color(0xFFF1F1F1)
val ShimmerMediumGray = Color(0xFFE3E3E3)
val ShimmerDarkGray = Color(0xFF1D1D1D)

val Colors.welcomeScreenBkgColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Color.White

val Colors.titleColor
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray else DarkGray

val Colors.descriptionColor
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray.copy(alpha = 0.5f) else DarkGray.copy(0.5f)

val Colors.activeIndicatorColor
    @Composable
    get() = if (isSystemInDarkTheme()) Purple700 else Purple500

val Colors.inactiveIndicatorColor
    @Composable
    get() = if (isSystemInDarkTheme()) DarkGray else LightGray

val Colors.buttonBkgColor
    @Composable
    get() = if (isSystemInDarkTheme()) Purple700 else Purple500

val Colors.topAppBarContentColor
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray else Color.White

val Colors.topAppBarBkgColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Purple500

val Colors.topAppBarIconColor
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray else Color.White