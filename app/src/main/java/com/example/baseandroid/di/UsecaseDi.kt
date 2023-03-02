package com.example.baseandroid.di

import com.example.baseandroid.common.AsyncFlowableTransformer
import com.example.domain.usecases.AppUseCase
import org.koin.core.qualifier.named

import org.koin.dsl.module

val mUseCaseModule = module {

    factory(named("usecase")) {
        AppUseCase(
            transformer = AsyncFlowableTransformer(),
            repositories = get(named("AppRepository"))
        )
    }
}