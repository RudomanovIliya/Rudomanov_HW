package com.example.hw_together.domain.models

import com.example.hw_together.data.database.entity.NotePartEntity

data class NotePart(
    val text: String? = null,
    val image: String = ""
)

fun NotePart.toEntity(): NotePartEntity {
    return NotePartEntity(
        text = text,
        image = image
    )
}