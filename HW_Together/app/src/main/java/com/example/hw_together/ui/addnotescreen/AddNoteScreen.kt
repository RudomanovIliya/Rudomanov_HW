package com.example.hw_together.ui.addnotescreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.hw_together.ui.addnotescreen.components.AddNoteScreenContent

@Composable
fun AddNoteScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
    viewModel: AddNoteScreenViewModel
) {
    LaunchedEffect(key1 = Unit) {
        setBottomBarVisibility(true)
    }
    AddNoteScreenContent(bottomBarHeight = bottomBarHeight, viewModel = viewModel)
}