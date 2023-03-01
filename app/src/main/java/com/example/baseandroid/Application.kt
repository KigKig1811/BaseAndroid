package com.example.baseandroid

import android.app.Application
import com.example.baseandroid.di.mNetworkModules
import com.example.baseandroid.di.mRepositoryModules
import com.example.baseandroid.di.mUseCaseModule
import com.example.baseandroid.di.memCacheModule
import com.example.baseandroid.feature.beer.di.beerModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() {
        startKoin {
            AndroidLogger()
            androidContext(this@Application)
            modules(
                mNetworkModules, mRepositoryModules, memCacheModule, mUseCaseModule, beerModule
            )
        }
    }
}