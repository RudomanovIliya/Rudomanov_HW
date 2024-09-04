package com.example.hw_together.ui.addnotescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import coil.ImageLoader
import com.example.hw_together.domain.models.NotePart
import com.example.hw_together.domain.usecases.SaveNoteUseCase
import com.example.hw_together.ui.addnotescreen.models.SwitchState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class AddNoteScreenViewModel @Inject constructor(
    private val saveNoteUseCase: SaveNoteUseCase,
    private val imageLoader: ImageLoader,
) : ViewModel(), ContainerHost<AddNoteScreenState, Nothing> {
    override val container = container<AddNoteScreenState, Nothing>(
        AddNoteScreenState()
    )

    fun titleChange(title: String) = blockingIntent {
        reduce {
            state.copy(
                note = state.note.copy(
                    title = title,
                )
            )
        }
    }

    fun textChange(index: Int, text: String) = blockingIntent {
        Log.e("e", state.note.content.toString())
        Log.e("e", text + "text")
        val url = state.note.content[index].image
        reduce {
            state.copy(
                note = state.note.copy(
                    content = state.note.content.toMutableList().apply {
                        set(
                            index,
                            NotePart(text = text, image = url)
                        )
                    })
            )
        }
        Log.e("e", state.note.content.toString())
    }

    fun toLocalSwitch() = intent {
        reduce { state.copy(pathNote = SwitchState.Local) }
    }

    fun toCommunitySwitch() = intent {
        reduce { state.copy(pathNote = SwitchState.Community) }
    }

    fun visibilityBottomSheen() = intent {
        reduce { state.copy(visibilityBottomSheet = !state.visibilityBottomSheet) }
    }

    fun visibilityDialog() = intent {
        reduce {
            state.copy(visibilityDialog = !state.visibilityDialog)
        }
    }

    fun visibilityErrorDialog() = intent {
        val text = state.note.content[state.note.content.size - 1].text
        reduce {
            state.copy(
                visibilityErrorDialog = !state.visibilityErrorDialog,
                note = state.note.copy(content = state.note.content.toMutableList().apply {
                    set(
                        state.note.content.size - 1,
                        NotePart(text = text, image = "")
                    )
                })
            )
        }
        Log.e("e", state.note.content.toString())
    }

    fun urlChange(url: String) = blockingIntent {
        reduce {
            state.copy(imageText = url)
        }
        Log.e("e", state.note.content.toString())
    }

    fun urlSave() = intent {
        val text = state.note.content[state.note.content.size - 1].text
        reduce {
            state.copy(
                note = state.note.copy(
                    content = state.note.content.toMutableList().apply {
                        set(
                            state.note.content.size - 1,
                            NotePart(text = text, image = state.imageText)
                        )
                    })
            )
        }
        Log.e("e", state.note.content.toString())
    }

    fun addNoteImage() = intent {
        reduce {
            state.copy(
                note = state.note.copy(
                    content = state.note.content.toMutableList().apply { add(NotePart()) }),
            )
        }
        Log.e("e", state.note.content.toString())
    }

    fun addNoteText() = intent {
        reduce {
            state.copy(
                note = state.note.copy(
                    content = state.note.content.toMutableList()
                        .apply { add(NotePart(text = "")) }),
            )
        }
        Log.e("e", state.note.content.toString())
    }

    fun loadImage(): ImageLoader {
        return imageLoader
    }

    fun saveNoteLocal() = intent {
        saveNoteUseCase.invoke(note = state.note)
    }
}