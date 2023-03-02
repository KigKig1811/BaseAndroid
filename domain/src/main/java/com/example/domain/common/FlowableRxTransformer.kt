package com.example.domain.common

import io.reactivex.FlowableTransformer

abstract class FlowableRxTransformer<T> : FlowableTransformer<T, T> {
}