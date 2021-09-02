package com.example.di

import com.example.data.repository.CharacterRepositoryImpl
import com.example.domain.repository.CharacterRepository
import com.example.domain.usecase.CharacterUseCase
import com.example.domain.usecase.CharacterUseCaseImpl
import org.koin.dsl.module

val useCasesModule = module {
    single<CharacterUseCase> { CharacterUseCaseImpl(get()) }
}

val repositoriesModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl() }
}
