package io.relaworld.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.relaworld.api.models.entities.LoginCreds

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "user")
    val user: LoginCreds
)