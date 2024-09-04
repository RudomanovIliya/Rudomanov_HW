package com.example.hw_together.ui.addnotescreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.hw_together.ui.addnotescreen.components.AddNoteScreenContent
import com.example.hw_together.ui.addnotescreen.components.CustomDialog
import com.example.hw_together.ui.addnotescreen.components.CustomErrorDialog
import com.example.hw_together.ui.addnotescreen.components.CustomModalBottomSheet
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun AddNoteScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
    viewModel: AddNoteScreenViewModel
) {
    val state = viewModel.collectAsState().value
    LaunchedEffect(key1 = Unit) {
        setBottomBarVisibility(true)
    }
    AddNoteScreenContent(
        bottomBarHeight = bottomBarHeight,
        viewModel = viewModel,
        onLeftSwitchClick = remember { { viewModel.toLocalSwitch() } },
        onRightSwitchClick = remember { { viewModel.toCommunitySwitch() } },
    )
    if (state.visibilityBottomSheet) {
        CustomModalBottomSheet(
            onDismissRequest = remember { { viewModel.visibilityBottomSheen() } },
            onTextClick = remember { { viewModel.addNoteText() } },
            onImageClick = remember {
                {
                    viewModel.visibilityDialog()
                    viewModel.visibilityBottomSheen()
                }
            })
    }
    if (state.visibilityDialog) {
        CustomDialog(
            value = state.imageText,
            onValueChange = remember { { viewModel.urlChange(it) } },
            onDismissRequest = remember { { viewModel.visibilityDialog() } },
            onAddClick = remember { { viewModel.urlSave() } },
            onCancelClick = remember { { viewModel.visibilityDialog() } })
    }
    if (state.visibilityErrorDialog) {
        CustomErrorDialog(onDismissRequest = remember { { viewModel.visibilityErrorDialog() } })
    }
}