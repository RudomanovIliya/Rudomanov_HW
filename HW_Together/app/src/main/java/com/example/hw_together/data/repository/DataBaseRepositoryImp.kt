package com.example.hw_together.data.repository

import com.example.hw_together.data.database.NotesDataBase
import com.example.hw_together.data.database.entity.NoteEntity
import com.example.hw_together.domain.models.Note
import com.example.hw_together.domain.models.toEntity
import com.example.hw_together.domain.repository.DataBaseRepository
import javax.inject.Inject

class DataBaseRepositoryImp @Inject constructor(
    private val dataBase: NotesDataBase
) : DataBaseRepository {
    override suspend fun saveNote(note: Note) {
        dataBase.noteDao().saveNote(
            NoteEntity(
                id = 0,
                title = note.title,
                content = note.content.map { it.toEntity() }
            )
        )
    }
}