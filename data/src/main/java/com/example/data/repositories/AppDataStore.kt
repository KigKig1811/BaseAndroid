package com.example.data.repositories

import com.example.domain.entities.BeerResult
import com.example.domain.entities.ListBeerResult
import io.reactivex.Flowable


interface AppDataStore {
    fun requestGetBeers(): Flowable<List<BeerResult>>
}