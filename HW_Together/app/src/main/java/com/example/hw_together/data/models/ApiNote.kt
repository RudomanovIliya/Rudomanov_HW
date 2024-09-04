package com.example.hw_together.data.models

data class ApiNote(
    val title: String,
    val content: List<ApiNotePart>
)