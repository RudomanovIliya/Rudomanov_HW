package com.example.hw_together.domain.usecases

import com.example.hw_together.domain.models.Note
import com.example.hw_together.domain.repository.DataBaseRepository

class SaveNoteLocalUseCase(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend operator fun invoke(note: Note) {
        return dataBaseRepository.saveNote(note)
    }
}
