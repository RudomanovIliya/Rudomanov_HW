package com.example.hw_together.ui.addnotescreen

import android.icu.text.CaseMap.Title
import androidx.lifecycle.ViewModel
import com.example.hw_together.domain.models.NotePart
import com.example.hw_together.domain.usecases.SaveNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class AddNoteScreenViewModel @Inject constructor(
    private val saveNoteUseCase: SaveNoteUseCase
) : ViewModel(), ContainerHost<AddNoteScreenState, Nothing> {
    override val container = container<AddNoteScreenState, Nothing>(
        AddNoteScreenState()
    )

    fun titleChange(title: String) = intent {
        reduce {
            state.copy(
                note = state.note.copy(
                    title = title,
                )
            )
        }
        saveNoteUseCase.invoke(note = state.note)
    }

    fun saveNote() = intent {
        reduce {
            state.copy(
                note = state.note.copy(
                    title = "1",
                    content = listOf(NotePart(text = "2", image = "3"))
                )
            )
        }
        saveNoteUseCase.invoke(note = state.note)
    }
}