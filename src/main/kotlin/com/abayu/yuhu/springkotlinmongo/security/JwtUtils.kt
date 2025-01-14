package com.abayu.yuhu.springkotlinmongo.security

import com.abayu.yuhu.springkotlinmongo.documents.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.HashMap

@Component
class JwtUtils {
    private val secretKey = "SECRET_KEY"

    fun generateToken(user: User): String {
        val claims: Map<String, Any> = HashMap()
        return createToken(claims, user)
    }

    private fun createToken(claims: Map<String, Any>, subject: User): String {
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject.toString())
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact()
    }

    fun validateToken(token: String, username: String): Boolean {
        val tokenUsername = extractUsername(token)
        return (username == tokenUsername && !isTokenExpired(token))
    }

    fun extractUsername(token: String): String {
        return extractClaim(token, Claims::getSubject)
    }

    fun <T> extractClaim(token: String, claimsResolver: (Claims) -> T): T {
        val claims = extractAllClaims(token)
        return claimsResolver(claims)
    }

    private fun extractAllClaims(token: String): Claims {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body
    }

    private fun isTokenExpired(token: String): Boolean {
        return extractExpiration(token).before(Date())
    }

    private fun extractExpiration(token: String): Date {
        return extractClaim(token, Claims::getExpiration)
    }
}
