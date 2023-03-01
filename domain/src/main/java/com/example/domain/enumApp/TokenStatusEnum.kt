package com.example.domain.enumApp

enum class TokenStatusEnum {
    LOGGER_OUT {
        override fun localization(): String = "Logger out"
    },
    SESSION_TIME_OUT {
        override fun localization(): String = "Session time out"
    },
    ENABLE_AUTHENTICATION {
        override fun localization(): String = "Enable Authentication"
    },
    CHANGE_PASSWORD {
        override fun localization(): String = "Change password"
    },
    TWO_FACTOR_AUTHENTICATION {
        override fun localization(): String = "Two factor authentication"
    },
    LOGGER_IN {
        override fun localization(): String = "Logger in"
    },
    TOKEN_NOT_FOUND{
        override fun localization(): String = "Token not found"
    },
    ACCEPTANCE_TERMS_OF_SERVICES{
        override fun localization(): String = "Acceptance Terms of Services"
    },
    MISSING_CHANNEL{
        override fun localization(): String = "Missing channel"
    },
    UNKNOW{
        override fun localization(): String = "unknow"
    };

    abstract fun localization(): String
    companion object{
        fun getTokenStatusEnum(type: String): TokenStatusEnum {
            return when(type){
                "Logged out" -> LOGGER_OUT
                "Session time out" -> SESSION_TIME_OUT
                "Enable Authentication" -> ENABLE_AUTHENTICATION
                "Change password" -> CHANGE_PASSWORD
                "Two factor authentication" -> TWO_FACTOR_AUTHENTICATION
                "Logged in" -> LOGGER_IN
                "Token not found" -> TOKEN_NOT_FOUND
                "Missing channel" -> MISSING_CHANNEL
                "Acceptance Terms of Services" -> ACCEPTANCE_TERMS_OF_SERVICES
                else -> UNKNOW
            }
        }
    }
}