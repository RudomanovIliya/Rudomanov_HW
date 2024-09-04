package com.example.hw_together.ui.addnotescreen.models

import androidx.compose.runtime.Stable

@Stable
enum class SwitchState(val path: Boolean) {
    Local(true), Community(false)
}