package com.example.hw_together.data.database.entity

import androidx.room.TypeConverter
import com.example.hw_together.domain.models.NotePart
import com.google.gson.Gson

class Converter {

    @TypeConverter
    fun listToJson(value: List<NotePartEntity>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<NotePartEntity>::class.java).toList()
}