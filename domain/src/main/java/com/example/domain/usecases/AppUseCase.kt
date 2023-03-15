package com.example.domain.usecases

import com.example.domain.common.BaseFlowableUseCase
import com.example.domain.common.FlowableRxTransformer
import com.example.domain.entities.BeerResult
import com.example.domain.entities.ListBeerResult
import com.example.domain.repositories.AppRepository
import io.reactivex.Flowable


class AppUseCase(
    private val transformer: FlowableRxTransformer<List<BeerResult>>,
    private val repositories: AppRepository
) : BaseFlowableUseCase<List<BeerResult>>(transformer) {
    override fun createFlowable(data: Map<String, Any>?): Flowable<List<BeerResult>> {
        val map = mutableMapOf<String, Any>()
        return if (data !== null) {
            data.forEach { map[it.key] = it.value }
            repositories.requestGetListBeer(mapOf())
        } else {
            repositories.requestGetListBeer(mapOf())
        }
    }

    fun requestGetBeer(): Flowable<List<BeerResult>> {
        val data = mapOf<String,Any>(
        )
        return single(data)
    }
}