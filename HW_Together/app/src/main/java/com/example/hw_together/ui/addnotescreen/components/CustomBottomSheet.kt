package com.example.hw_together.ui.addnotescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.R
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomModalBottomSheet(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    onTextClick: () -> Unit,
    onImageClick: () -> Unit
) {
    ModalBottomSheet(
        containerColor = Color.White,
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        dragHandle = {},
        modifier = modifier.fillMaxWidth(), sheetMaxWidth = 80.dp,
        onDismissRequest = onDismissRequest
    ) {
        ModalBottomSheetContent(
            onTextClick = onTextClick,
            onImageClick = onImageClick
        )
    }
}

@Composable
fun ModalBottomSheetContent(
    modifier: Modifier = Modifier,
    onTextClick: () -> Unit,
    onImageClick: () -> Unit
) {
    Column(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            text = "Что добавить?",
            style = LocalTypography.current.snackBarHeader
        )
        CustomBottomSheetItem(
            modifier = Modifier.clickable(onClick = onTextClick),
            text = "Текст",
            imageRes = R.drawable.ic_text
        )
        CustomBottomSheetItem(
            modifier = Modifier.clickable(onClick = onImageClick),
            text = "Ссылка на фото",
            imageRes = R.drawable.ic_image
        )
    }
}

@Composable
fun CustomBottomSheetItem(
    modifier: Modifier = Modifier,
    imageRes: Int,
    text: String,
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier.padding(vertical = 8.dp),
            painter = painterResource(id = imageRes),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .padding(start = 12.dp)
                .padding(vertical = 14.dp),
            text = text,
            style = LocalTypography.current.smallBody
        )
    }
}

@Preview
@Composable
fun CustomSnackBarPreview() {
    HW_TogetherTheme {
        //CustomSnackBar()
        // CustomModalBottomSheet(onDismissRequest = {})
        ModalBottomSheetContent(onImageClick = {}, onTextClick = {})
    }
}