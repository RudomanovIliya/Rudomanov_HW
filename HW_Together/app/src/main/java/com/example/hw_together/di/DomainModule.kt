package com.example.hw_together.di

import com.example.hw_together.data.api.ApiAuthorization
import com.example.hw_together.data.api.ApiNotes
import com.example.hw_together.data.database.NotesDataBase
import com.example.hw_together.data.repository.AuthorizationRepositoryImpl
import com.example.hw_together.data.repository.DataBaseRepositoryImp
import com.example.hw_together.domain.repository.AuthorizationRepository
import com.example.hw_together.domain.repository.DataBaseRepository
import com.example.hw_together.domain.usecases.LoginUseCase
import com.example.hw_together.domain.usecases.RegisterUseCase
import com.example.hw_together.domain.usecases.SaveNoteUseCase
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
    fun provideAuthorizationRepository(apiAuthorization: ApiAuthorization): AuthorizationRepository {
        return AuthorizationRepositoryImpl(apiAuthorization = apiAuthorization)
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
    fun provideSaveNoteUseCase(dataBaseRepository: DataBaseRepository): SaveNoteUseCase {
        return SaveNoteUseCase(dataBaseRepository = dataBaseRepository)
    }

}