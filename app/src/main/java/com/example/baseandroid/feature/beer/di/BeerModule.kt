package com.example.baseandroid.feature.beer.di

import com.example.baseandroid.feature.beer.BeerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val beerModule = module {
    viewModel { BeerViewModel(get(named("usecase"))) }
}