package com.example.baseandroid.di

import com.example.baseandroid.BuildConfig
import com.example.baseandroid.network.createNetworkClient
import org.koin.dsl.module

private const val RETROFIT_INSTANCE = "Retrofit"
val mNetworkModules = module {
   single { createNetworkClient(BuildConfig.BASE_URL) }
}