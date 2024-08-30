package com.example.hw_together.domain.repository

import com.example.hw_together.domain.models.Note

interface DataBaseRepository {
    suspend fun saveNote(note: Note)
}