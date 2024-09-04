package com.example.hw_together.domain.models

import com.example.hw_together.data.database.entity.NotePartEntity
import com.example.hw_together.data.models.ApiNotePart

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
fun NotePart.toApiModel(): ApiNotePart {
    return ApiNotePart(
        text = text,
        image = image
    )
}