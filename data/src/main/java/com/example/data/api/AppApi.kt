package com.example.data.api

import io.reactivex.Flowable
import retrofit2.http.GET

interface AppApi {
    @GET("beers")
    fun getListBeer(
//        @Query(value = "page") page: Int,
//        @Query(value = "per_page") per_page: String,
    ): Flowable<String>
}