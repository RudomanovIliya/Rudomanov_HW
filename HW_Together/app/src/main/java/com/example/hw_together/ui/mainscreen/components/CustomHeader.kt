package com.example.hw_together.ui.mainscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors
import com.example.hw_together.ui.theme.LocalTypography

@Composable
fun CustomHeader(
    modifier: Modifier = Modifier,
    text: String = "",
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(8.dp),
                color = LocalColors.current.gray
            )
            .height(32.dp)
            .fillMaxWidth()
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = LocalTypography.current.bodyButtonAuthorization
        )
        Spacer(modifier = Modifier.weight(1f))
        Spacer(
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
                .background(color = Color.White)
        )
        Text(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(horizontal = 12.dp, vertical = 8.dp),
            text = "Все",
            style = LocalTypography.current.smallBody,
            color = LocalColors.current.darkGray
        )
    }

}

@Preview
@Composable
fun CustomHeaderPreview() {
    HW_TogetherTheme {
        CustomHeader(text = "Ваши курсы", onClick = {})
    }
}