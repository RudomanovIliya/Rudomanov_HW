package com.example.hw_together.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.hw_together.data.database.entity.NoteEntity

@Dao
interface NoteDao {
    @Insert()
    suspend fun saveNote(note: NoteEntity)
}