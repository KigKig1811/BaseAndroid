package com.example.data.repositories

import com.example.domain.entities.ListBeerResult
import io.reactivex.rxjava3.core.Flowable

interface AppDataStore {
    fun requestGetBeers(): Flowable<ListBeerResult>
}