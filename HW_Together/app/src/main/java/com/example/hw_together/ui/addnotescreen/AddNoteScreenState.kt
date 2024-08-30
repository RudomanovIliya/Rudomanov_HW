package com.example.hw_together.ui.addnotescreen

import com.example.hw_together.domain.models.Note
import com.example.hw_together.domain.models.NotePart


data class AddNoteScreenState(
    val note: Note = Note(title = "", content = listOf<NotePart>())
)