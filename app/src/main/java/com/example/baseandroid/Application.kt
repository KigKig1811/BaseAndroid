package com.example.baseandroid

import android.app.Application
import com.example.baseandroid.di.mNetworkModules
import com.example.baseandroid.di.mRepositoryModules
import com.example.baseandroid.di.mUseCaseModule
import com.example.baseandroid.di.memCacheModule
import org.koin.core.context.startKoin
import timber.log.Timber






class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            modules(
                mNetworkModules, mRepositoryModules, memCacheModule, mUseCaseModule
            )
        }
    }
}