package com.example.hw_together.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hw_together.domain.models.NotePart

@Entity(tableName = NoteEntity.TABLE_NAME)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "Title")
    val title: String,
    @ColumnInfo(name = "NoteData")
    val content: List<NotePartEntity>
) {
    companion object {
        const val TABLE_NAME = "notes"
    }
}