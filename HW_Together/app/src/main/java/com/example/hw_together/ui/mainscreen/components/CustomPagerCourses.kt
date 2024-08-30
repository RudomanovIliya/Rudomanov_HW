package com.example.hw_together.ui.mainscreen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hw_together.ui.theme.HW_TogetherTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomPagerCourses(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        val pagerState = rememberPagerState(pageCount = { 6 })
        HorizontalPager(state = pagerState) {

        }
    }
}

@Preview
@Composable
fun CustomPagerCoursesPreview() {
    HW_TogetherTheme {
        CustomPagerCourses()
    }
}