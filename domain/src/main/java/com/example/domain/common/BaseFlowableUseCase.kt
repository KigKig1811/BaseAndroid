package com.example.domain.common

import io.reactivex.rxjava3.core.Flowable

abstract class BaseFlowableUseCase<T>(private val transformer: FlowableRxTransformer<T>) {

    abstract fun createFlowable(data: Map<String, Any>? = null): Flowable<T>

    fun single(withData: Map<String, Any>? = null): Flowable<T> {
        return createFlowable(withData).compose(transformer)
    }
    companion object{
        const val PARAM_TOKEN = "token"
    }


}