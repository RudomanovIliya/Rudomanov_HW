package com.example.hw_together.domain.usecases

import com.example.hw_together.domain.models.Note
import com.example.hw_together.domain.repository.NoteRepository
import retrofit2.Response
import javax.inject.Inject

class SaveNoteCommunityUseCase (
    private val noteRepository: NoteRepository
) {
//    suspend operator fun invoke(note: Note): Response<String> {
//       return noteRepository.saveNote(note)
//    }
}