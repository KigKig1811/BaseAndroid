package com.example.data.repositories

import com.example.data.utils.JwtParserUtil
import com.example.domain.entities.BeerResult
import com.example.domain.entities.ListBeerResult
import com.example.domain.repositories.AppRepository
import io.reactivex.Flowable

class AppRepositoryImpl(private val remote: AppRemoteImpl): AppRepository {
    override fun requestGetListBeer(mapRequest: Map<String, String>): Flowable<List<BeerResult>> {
        val editMap = mapRequest.toMutableMap()
        val token: String = JwtParserUtil.parseToToken(editMap)
        return remote.requestGetBeers()
    }
}