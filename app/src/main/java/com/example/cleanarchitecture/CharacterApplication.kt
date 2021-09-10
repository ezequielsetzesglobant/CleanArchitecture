package com.example.cleanarchitecture

import android.app.Application
import com.example.cleanarchitecture.di.viewModelsModule
import com.example.di.repositoriesModule
import com.example.di.useCasesModule
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.core.context.startKoin

class CharacterApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(viewModelsModule, useCasesModule, repositoriesModule))
        }
        Realm.init(this)
        Realm.setDefaultConfiguration(
            RealmConfiguration.Builder()
                .name(DATA_BASE_NAME)
                .schemaVersion(DATA_BASE_VERSION)
                .build()
        )
    }

    companion object {
        private const val DATA_BASE_NAME: String = "Characters Data Base"
        private const val DATA_BASE_VERSION: Long = 0
    }
}
