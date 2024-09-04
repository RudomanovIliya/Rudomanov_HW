package com.example.hw_together.ui.mainscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors
import com.example.hw_together.ui.theme.LocalTypography

@Composable
fun CustomNote(
    modifier: Modifier = Modifier,
    dateText: String = "",
    titleText: String = "",
    bodyText: String = ""
) {
    Box(
        modifier = modifier
           // .height(112.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 12.dp)
                .fillMaxWidth()
                .background(shape = RoundedCornerShape(8.dp), color = LocalColors.current.yellow)
                .padding(top = 12.dp, start = 12.dp, bottom = 12.dp, end = 12.dp)
        ) {
            Text(
                minLines = 1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.wrapContentWidth(),
                text = titleText,
                style = LocalTypography.current.bigBody
            )
            Text(
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .wrapContentWidth(),
                text = bodyText,
                style = LocalTypography.current.subHeaderAuthorization,
                color = LocalColors.current.blueLagoon
            )
        }
        Text(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = LocalColors.current.lightBlack
                )
                .padding(horizontal = 12.dp, vertical = 8.dp),
            text = dateText,
            style = LocalTypography.current.littleBody,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun CustomNotePreview() {
    HW_TogetherTheme {
        CustomNote(
            dateText = "12 июля",
            titleText = "Для создания новой Activity",
            bodyText = "Нужно лишь применить старый дедовский визард"
        )
    }
}