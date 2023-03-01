package com.example.domain.entities

import com.example.domain.enumApp.TokenStatusEnum
import java.lang.RuntimeException

data class TokenStatusThrowable(
    val tokenStatusEnum: TokenStatusEnum,
    val messageError: String?
): RuntimeException(messageError)