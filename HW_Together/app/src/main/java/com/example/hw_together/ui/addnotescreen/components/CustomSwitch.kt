package com.example.hw_together.ui.addnotescreen.components

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw_together.ui.theme.HW_TogetherTheme
import com.example.hw_together.ui.theme.LocalColors
import com.example.hw_together.ui.theme.LocalTypography

@Composable
fun CustomSwitch(
    modifier: Modifier = Modifier,
    state: Boolean,
    onLeftClick: () -> Unit,
    onRightClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = LocalColors.current.gray
            )
    ) {
        AnimatedContent(
            targetState = state,
            transitionSpec = {
                fadeIn(initialAlpha = 0f) + slideInHorizontally(animationSpec = tween(400),
                    initialOffsetX = {
                        if (state) {
                            0
                        } else {
                            it
                        }
                    }) togetherWith
                        fadeOut(targetAlpha = 1f) + slideOutHorizontally(
                    animationSpec = tween(400),
                    targetOffsetX = {
                        if (state) {
                            -it / 2
                        } else {
                            it / 2
                        }
                    },
                )
            }
        ) { targetState ->
            Log.e("e", "switch " + state.toString())
            if (targetState) {
                LeftTrigger()
            } else {
                RightTrigger()
            }
        }
        Text(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clip(shape = RoundedCornerShape(8.dp))
                .clickable(onClick = onLeftClick)
                .padding(vertical = 10.dp)
                .fillMaxWidth(fraction = 0.5f),
            text = "Локально",
            textAlign = TextAlign.Center,
            style = LocalTypography.current.bodyButtonAuthorization
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clip(shape = RoundedCornerShape(8.dp))
                .clickable(onClick = onRightClick)
                .padding(vertical = 10.dp)
                .fillMaxWidth(fraction = 0.5f),
            text = "Глобально",
            textAlign = TextAlign.Center,
            style = LocalTypography.current.bodyButtonAuthorization
        )
    }
}

@Composable
fun LeftTrigger(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
    ) {
        Spacer(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth(fraction = 0.5f)
                .fillMaxHeight()
                .background(shape = RoundedCornerShape(8.dp), color = LocalColors.current.yellow)
        )
    }
}

@Composable
fun RightTrigger(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.End
    ) {
        Spacer(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth(0.5f)
                .fillMaxHeight()
                .background(shape = RoundedCornerShape(8.dp), color = LocalColors.current.yellow)
        )
    }
}

@Preview
@Composable
fun CustomSwitchPreview() {
    HW_TogetherTheme {
        CustomSwitch(
            state = true, onLeftClick = {}, onRightClick = {}
        )
    }
}

