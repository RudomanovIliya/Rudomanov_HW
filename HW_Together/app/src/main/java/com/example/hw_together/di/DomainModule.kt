package com.example.hw_together.di

import com.example.hw_together.data.api.ApiRequests
import com.example.hw_together.data.database.NotesDataBase
import com.example.hw_together.data.repository.AuthorizationRepositoryImpl
import com.example.hw_together.data.repository.DataBaseRepositoryImp
import com.example.hw_together.data.repository.NoteRepositoryImpl
import com.example.hw_together.domain.repository.AuthorizationRepository
import com.example.hw_together.domain.repository.DataBaseRepository
import com.example.hw_together.domain.repository.NoteRepository
import com.example.hw_together.domain.usecases.LoginUseCase
import com.example.hw_together.domain.usecases.RegisterUseCase
import com.example.hw_together.domain.usecases.SaveNoteCommunityUseCase
import com.example.hw_together.domain.usecases.SaveNoteLocalUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideAuthorizationRepository(apiRequests: ApiRequests): AuthorizationRepository {
        return AuthorizationRepositoryImpl(apiRequests = apiRequests)
    }

    @Provides
    @Singleton
    fun provideRegisterUserUseCase(authorizationRepository: AuthorizationRepository): RegisterUseCase {
        return RegisterUseCase(authorizationRepository = authorizationRepository)
    }

    @Provides
    @Singleton
    fun provideLoginUserUseCase(authorizationRepository: AuthorizationRepository): LoginUseCase {
        return LoginUseCase(authorizationRepository = authorizationRepository)
    }

    @Provides
    @Singleton
    fun provideDataBaseRepository(dataBase: NotesDataBase): DataBaseRepository {
        return DataBaseRepositoryImp(dataBase = dataBase)
    }

    @Provides
    @Singleton
    fun provideSaveNoteLocalUseCase(dataBaseRepository: DataBaseRepository): SaveNoteLocalUseCase {
        return SaveNoteLocalUseCase(dataBaseRepository = dataBaseRepository)
    }

    @Provides
    @Singleton
    fun provideNoteRepository(apiRequests: ApiRequests): NoteRepository {
        return NoteRepositoryImpl(apiRequests = apiRequests)
    }

    @Provides
    @Singleton
    fun provideSaveNoteCommunityUseCase(noteRepository: NoteRepository): SaveNoteCommunityUseCase {
        return SaveNoteCommunityUseCase(noteRepository = noteRepository)
    }
}