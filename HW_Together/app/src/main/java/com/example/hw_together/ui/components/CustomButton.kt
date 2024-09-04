package com.example.hw_together.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.R
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors
import com.example.hw_together.ui.theme.LocalTypography

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    textColor: Color,
    isLoading: Boolean = false
) {
    if (isLoading) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(40.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp),
                color = LocalColors.current.yellow
            )
        }
    } else {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .height(40.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .clickable(onClick = onClick)
                .wrapContentHeight(),
            text = text,
            textAlign = TextAlign.Center,
            style = LocalTypography.current.bodyButtonAuthorization,
            color = textColor
        )
    }
}

@Composable
fun CustomButtonWithImage(
    modifier: Modifier = Modifier,
    imageResource: Int,
    onClick: () -> Unit
) {
    Image(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(8.dp),
                color = LocalColors.current.lightBlack
            )
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .size(40.dp),
        contentScale = ContentScale.None,
        painter = painterResource(id = imageResource),
        contentDescription = null
    )
}


@Preview
@Composable
fun CustomButtonPreview() {
    HW_TogetherTheme {
        Column {
            CustomButton(
                modifier = Modifier.background(color = LocalColors.current.yellow),
                text = "Test",
                textColor = LocalColors.current.lightBlack,
                onClick = {}
            )
            CustomButtonWithImage(imageResource = R.drawable.ic_plus, onClick = {})
        }
    }
}