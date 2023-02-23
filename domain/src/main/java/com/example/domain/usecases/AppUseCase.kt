package com.example.domain.usecases

import com.example.domain.common.BaseFlowableUseCase
import com.example.domain.common.FlowableRxTransformer
import com.example.domain.entities.ListBeerResult
import com.example.domain.repositories.AppRepository
import io.reactivex.rxjava3.core.Flowable

class AppUseCase(
    private val transformer: FlowableRxTransformer<ListBeerResult>,
    private val repositories: AppRepository
) : BaseFlowableUseCase<ListBeerResult>(transformer) {
    override fun createFlowable(data: Map<String, Any>?): Flowable<ListBeerResult> {
        val map = mutableMapOf<String, Any>()
        return if (data !== null) {
            data.forEach { map[it.key] = it.value }
            repositories.requestGetListBeer(mapOf())
        } else {
            repositories.requestGetListBeer(mapOf())
        }
    }
}