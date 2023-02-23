package com.example.data.repositories

import com.example.data.utils.JwtParserUtil
import com.example.domain.entities.ListBeerResult
import com.example.domain.repositories.AppRepository
import io.reactivex.rxjava3.core.Flowable

class AppRepositoryImpl(private val remote: AppRemoteImpl): AppRepository {
    override fun requestGetListBeer(mapRequest: Map<String, String>): Flowable<ListBeerResult> {
        val editMap = mapRequest.toMutableMap()
        val token: String = JwtParserUtil.parseToToken(editMap)
        return remote.requestGetBeers()
    }
}