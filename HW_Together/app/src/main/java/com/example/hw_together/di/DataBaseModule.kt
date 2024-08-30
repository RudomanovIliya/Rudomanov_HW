package com.example.hw_together.di

import android.content.Context
import androidx.room.Room
import com.example.hw_together.data.database.NotesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): NotesDataBase {
        return Room.databaseBuilder(
            context,
            NotesDataBase::class.java,
            NotesDataBase.DATABASE_NAME
        ).build()
    }
}