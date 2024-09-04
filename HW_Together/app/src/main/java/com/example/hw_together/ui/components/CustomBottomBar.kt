package com.example.hw_together.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.R
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors

const val MAIN_TAB = 0
const val FAVORITES_TAB = 1
const val ADD_TAB = 2
const val CHAT_TAB = 3
const val PROFILE_TAB = 4

@Composable
fun CustomBottomBar(
    modifier: Modifier = Modifier,
    onTabClick: (pos: Int) -> Unit,
) {
    val transparentBlackColor = LocalColors.current.transparentBlack
    Row(
        modifier = modifier
            //.safeDrawingPadding()
            .padding(
                bottom = WindowInsets.systemBars
                    .asPaddingValues()
                    .calculateBottomPadding()
            )
            .background(Color.White)
            .fillMaxWidth()
            .height(56.dp)
            .drawBehind {
                drawLine(
                    color = transparentBlackColor,
                    strokeWidth = 1.dp.toPx(),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                )
            }
            .padding(start = 16.dp, end = 8.dp)
            .wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomBottomBarItem(
            onClick = { onTabClick(MAIN_TAB) },
            imgResource = R.drawable.ic_home
        )
        CustomBottomBarItem(
            onClick = { onTabClick(FAVORITES_TAB) },
            imgResource = R.drawable.ic_save
        )
        CustomBottomBarItem(
            onClick = { onTabClick(ADD_TAB) },
            imgResource = R.drawable.ic_add
        )
        CustomBottomBarItem(
            onClick = { onTabClick(CHAT_TAB) },
            imgResource = R.drawable.ic_chat
        )
        CustomBottomBarItem(
            onClick = { onTabClick(PROFILE_TAB) },
            imgResource = R.drawable.ic_profile
        )
    }
}

@Composable
fun CustomBottomBarItem(
    modifier: Modifier = Modifier,
    imgResource: Int,
    onClick: () -> Unit,
) {
    Image(
        modifier = modifier
            .padding(end = 8.dp)
            .clip(shape = RoundedCornerShape(33.dp))
            .clickable(onClick = onClick),
        painter = painterResource(imgResource),
        contentDescription = ""
    )
}

@Preview
@Composable
fun CustomBottomBarPreview(
) {
    HW_TogetherTheme() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalAlignment = Alignment.Bottom
        ) {


            CustomBottomBar(modifier = Modifier, onTabClick = {})
        }
    }
}