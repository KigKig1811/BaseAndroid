package com.example.domain.repositories

import com.example.domain.entities.ListBeerResult
import io.reactivex.rxjava3.core.Flowable

interface AppRepository {
    fun requestGetListBeer(mapRequest: Map<String, String>): Flowable<ListBeerResult>
}