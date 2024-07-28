package com.example.hw6.extension

import android.content.res.Resources

fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()