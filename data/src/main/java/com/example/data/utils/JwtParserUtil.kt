package com.example.data.utils

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import java.lang.Exception
import java.nio.charset.StandardCharsets

class JwtParserUtil {
    companion object {
        private const val apiKey = "API_KEY"
        private const val kId = "KID"

        fun parseToMap(token: String): Map<String, Any> {
            return try {
                val signKey = Keys.hmacShaKeyFor(apiKey.toByteArray(StandardCharsets.UTF_8))
                val jws: Jws<Claims> = Jwts.parserBuilder()
                    .setSigningKey(signKey)
                    .build()
                    .parseClaimsJws(token)
                jws.body
            } catch (e: Exception) {
                emptyMap()
            }
        }

        fun parseToToken(map: Map<String, String>): String {
            val signKey = Keys.hmacShaKeyFor(apiKey.toByteArray(StandardCharsets.UTF_8))
            return Jwts.builder()
                .setClaims(map)
                .signWith(signKey, SignatureAlgorithm.HS512)
                .setHeaderParam("kid", kId)
                .setHeaderParam("typ", "JWT")
                .compact()
        }

        fun parseToTokenAny(map: Map<String, Any>): String {
            val signKey = Keys.hmacShaKeyFor(apiKey.toByteArray(StandardCharsets.UTF_8))
            return Jwts.builder()
                .setClaims(map)
                .signWith(signKey, SignatureAlgorithm.HS512)
                .setHeaderParam("kid", kId)
                .setHeaderParam("typ", "JWT")
                .compact()
        }
    }
}