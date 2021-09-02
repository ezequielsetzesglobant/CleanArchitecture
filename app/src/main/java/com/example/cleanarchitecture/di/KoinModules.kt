package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { CharacterViewModel(get()) }
}
