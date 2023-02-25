package com.example.baseandroid.di

import com.example.baseandroid.BuildConfig
import com.example.baseandroid.network.createNetworkClient
import com.example.data.api.AppApi
import com.example.data.entities.MemCache
import com.example.data.repositories.AppRemoteImpl
import com.example.data.repositories.AppRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

private const val RETROFIT_INSTANCE = "Retrofit"
private const val API = "Api"
private const val APP_REMOTE = "App_Remote"

val mNetworkModules = module {
    single(qualifier = named(RETROFIT_INSTANCE)) { createNetworkClient(BuildConfig.BASE_URL) }
    single(qualifier = named(API)) { (get() as Retrofit).create(AppApi::class.java) }
}

val mRepositoryModules = module {
    single(qualifier = named(APP_REMOTE)) { AppRemoteImpl(api = get(named(API))) }
    single { AppRepositoryImpl(remote = get(named(APP_REMOTE))) }
}

val memCacheModule = module { single { MemCache() } }