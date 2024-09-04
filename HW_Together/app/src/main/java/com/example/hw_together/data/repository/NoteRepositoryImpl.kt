package com.example.hw_together.data.repository

import com.example.hw_together.data.api.ApiRequests
import com.example.hw_together.data.models.ApiNote
import com.example.hw_together.domain.models.Note
import com.example.hw_together.domain.models.toApiModel
import com.example.hw_together.domain.repository.NoteRepository
import retrofit2.Response
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val apiRequests: ApiRequests
) : NoteRepository {
//    override suspend fun saveNote(note: Note): Response<> {
//        return apiRequests.postNote(
//            ApiNote(
//                title = note.title,
//                content = note.content.map { it.toApiModel() }
//            )
//        )
//    }
}