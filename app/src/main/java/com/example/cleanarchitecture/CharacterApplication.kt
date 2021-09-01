package com.example.cleanarchitecture

import android.app.Application
import com.example.cleanarchitecture.di.viewModelsModule
import com.example.di.repositoriesModule
import com.example.di.useCasesModule
import org.koin.core.context.startKoin

class CharacterApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(viewModelsModule, useCasesModule, repositoriesModule))
        }
    }
}
