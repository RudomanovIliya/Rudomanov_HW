package com.example.hw_together.data.database.entity

import com.example.hw_together.domain.models.NotePart

data class NotePartEntity(
    val text: String?,
    val image: String
)

fun NotePartEntity.toModel(): NotePart {
    return NotePart(
        text = text,
        image = image
    )
}