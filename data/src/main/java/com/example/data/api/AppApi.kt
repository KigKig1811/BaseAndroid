package com.example.data.api

import com.example.domain.entities.BeerResult
import com.example.domain.entities.ListBeerResult
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface AppApi {
    @GET("beers")
    fun getListBeer(
//        @Query(value = "page") page: Int,
//        @Query(value = "per_page") per_page: String,
    ): Flowable<String>
}