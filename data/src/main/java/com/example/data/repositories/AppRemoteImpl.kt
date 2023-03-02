package com.example.data.repositories

import com.example.data.api.AppApi
import com.example.data.entities.ListBeerEntity
import com.example.data.mapper.AppMapper
import com.example.data.utils.JwtParserUtil
import com.example.domain.entities.ListBeerResult
import io.reactivex.Flowable

class AppRemoteImpl constructor(private val api: AppApi) : AppDataStore {

    private val appMapper = AppMapper()

    override fun requestGetBeers(): Flowable<ListBeerResult> {
        return api.getListBeer().map { tokenResponse ->
            val map: Map<String, Any?> = JwtParserUtil.parseToMap(tokenResponse)
            val beerEntity = ListBeerEntity.create(map)
            val model = appMapper.mapToListBeerResult(beerEntity)
            model
        }
    }
}