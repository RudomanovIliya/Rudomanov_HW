package com.example.hw_together.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.hw_together.data.database.dao.NoteDao
import com.example.hw_together.data.database.entity.Converter
import com.example.hw_together.data.database.entity.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = NotesDataBase.VERSION,
)
@TypeConverters(Converter::class)
abstract class NotesDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        const val DATABASE_NAME = "note_db"
        const val VERSION = 1
    }
}