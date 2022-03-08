package io.relaworld.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.relaworld.api.models.entities.UserCreds

@JsonClass(generateAdapter = true)
data class SignUpRequest(
    @Json(name = "user")
    val user: UserCreds
)