package com.example.hw_together.ui.addnotescreen.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.hw_together.R
import com.example.hw_together.ui.addnotescreen.AddNoteScreenViewModel
import com.example.hw_together.ui.components.CustomButton
import com.example.hw_together.ui.components.CustomButtonWithImage
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun AddNoteScreenContent(
    modifier: Modifier = Modifier,
    bottomBarHeight: Dp,
    viewModel: AddNoteScreenViewModel
) {
    val state = viewModel.collectAsState().value
    Column(modifier.fillMaxSize()) {
        CustomToolBarAddScreen()
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            CustomSwitch(
                modifier = Modifier.padding(top = 16.dp),
                state = state.pathNote.path,
                onLeftClick = remember { { viewModel.toLocalSwitch() } },
                onRightClick = remember { { viewModel.toCommunitySwitch() } })
            CustomBasicTextFieldHeaderAddScreen(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                value = state.note.title,
                defaultValue = "Название",
                onValueChange = remember { { viewModel.titleChange(it) } })
            LazyColumn(
                modifier = Modifier.padding(top = 4.dp, bottom = bottomBarHeight + 72.dp)
            ) {
                itemsIndexed(items = state.note.content) { index, item ->
                    if (item.text != null) {
                        CustomBasicTextFieldSubAddScreen(
                            modifier = Modifier.padding(top = 12.dp),
                            value = item.text,
                            defaultValue = "Описание заметки",
                            onValueChange = remember {
                                {
                                    viewModel.textChange(
                                        index = index,
                                        text = it
                                    )
                                }
                            }
                        )
                    }
                    if (!state.visibilityErrorDialog)
                        if (state.note.content[index].image.isNotEmpty()) {
                            AsyncImage(
                                modifier = Modifier.padding(top = 8.dp),
                                model = state.note.content[index].image,
                                contentDescription = null,
                                imageLoader = remember {
                                    viewModel.loadImage()
                                },
                                onError = remember { { viewModel.visibilityErrorDialog() } }
                            )
                        }
                }
            }
        }
    }

    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = bottomBarHeight + 16.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        CustomButtonWithImage(
            imageResource = R.drawable.ic_plus,
            onClick = remember { { viewModel.visibilityBottomSheen() } })
        CustomButton(
            modifier = Modifier
                .padding(start = 12.dp)
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = LocalColors.current.lightBlack
                ),
            text = "Готово",
            onClick = remember { { viewModel.saveNote() } },
            textColor = Color.White,
            isLoading = false//загрузка?
        )
    }
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

@Composable
@Preview
fun AddNoteScreenContentPreview() {
    HW_TogetherTheme {
        AddNoteScreenContent(
            modifier = Modifier.background(color = Color.White),
            bottomBarHeight = 0.dp,
            viewModel = hiltViewModel()
        )
    }
}