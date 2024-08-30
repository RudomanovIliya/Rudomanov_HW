package com.example.hw_together.ui.mainscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.example.hw_together.ui.mainscreen.components.MainScreenContent

@Composable
fun MainScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp
) {
    LaunchedEffect(key1 = Unit) {
        setBottomBarVisibility(true)
    }
    MainScreenContent()
}


