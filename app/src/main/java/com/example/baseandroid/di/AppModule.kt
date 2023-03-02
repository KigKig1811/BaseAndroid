package com.example.baseandroid.di

import com.example.baseandroid.BuildConfig
import com.example.baseandroid.network.createNetworkClient
import com.example.data.api.AppApi
import com.example.domain.entities.MemCache
import com.example.data.repositories.AppRemoteImpl
import com.example.data.repositories.AppRepositoryImpl
import com.example.domain.repositories.AppRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit


val mNetworkModules = module {
    single { createNetworkClient(BuildConfig.BASE_URL) }
    single { (get() as Retrofit).create(AppApi::class.java) }
}

val mRepositoryModules = module {
    single { AppRemoteImpl(api = get()) }
    single<AppRepository>(named("AppRepository")) { AppRepositoryImpl(remote = get()) }
}

val memCacheModule = module {
    single { MemCache() }
}