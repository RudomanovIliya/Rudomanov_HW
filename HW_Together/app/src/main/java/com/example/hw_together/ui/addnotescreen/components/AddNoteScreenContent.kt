package com.example.hw_together.ui.addnotescreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.ui.theme.HW_TogetherTheme

@Composable
fun AddNoteScreenContent() {
    //val context = LocalContext.current
    //val viewModel: AddNoteScreenViewModel = hiltViewModel()
    //val state = viewModel.collectAsState().value
    val checkState = remember {
        mutableStateOf(false)
    }
    Column(Modifier.fillMaxSize()) {
        CustomToolBarAddScreen()
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Switch(
                modifier = Modifier.fillMaxWidth(),
                checked = checkState.value,
                onCheckedChange = { checkState.value = it }
            )
            CustomBasicTextFieldHeaderAddScreen(
                modifier = Modifier.fillMaxWidth(),
                value = "1234",
                onValueChange = {})
        }
    }
}

@Composable
@Preview
fun AddNoteScreenContentPreview() {
    HW_TogetherTheme {
        AddNoteScreenContent()
    }
}