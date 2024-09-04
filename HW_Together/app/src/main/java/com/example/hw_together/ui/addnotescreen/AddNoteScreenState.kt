package com.example.hw_together.ui.addnotescreen

import com.example.hw_together.domain.models.Note
import com.example.hw_together.domain.models.NotePart
import com.example.hw_together.ui.addnotescreen.models.SwitchState


data class AddNoteScreenState(
    val note: Note = Note(
        title = "",
        content = listOf<NotePart>(NotePart(text = "", image = ""))
    ),
    val imageText: String = "",
    val notePart: NotePart = NotePart(text = "", image = ""),
    val pathNote: SwitchState = SwitchState.Local,
    val visibilityBottomSheet: Boolean = false,
    val visibilityDialog: Boolean = false,
    val visibilityErrorDialog: Boolean = false,
)