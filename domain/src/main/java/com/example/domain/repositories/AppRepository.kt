package com.example.domain.repositories

import com.example.domain.entities.ListBeerResult
import io.reactivex.Flowable

interface AppRepository {
    fun requestGetListBeer(mapRequest: Map<String, String>): Flowable<ListBeerResult>
}