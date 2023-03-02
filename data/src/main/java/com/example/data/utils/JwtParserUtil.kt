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
        private const val apiKey = "paQSl30RRJKQ4LISIb3DQEBAQUAA4GMHjasdHAdas024AS7sdHADds9JDSJASK2q23+Uis5tkliIbyShFmaJ40sc1ZgRjNLCcUis5tkliIbyShFmaJ40sc1ZgRj68AADCBiAKB2Zh/EkvT2h41j1KVrlMmQmUC0+Ky8Ad7MWCcNLCcUis5tkliIbyShFmaJ40sc1ZgRj6NSJKJrhfDiPZrD="
        private const val kId = "78623e77-5c42-4615-a640-58a88d0d2080"

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