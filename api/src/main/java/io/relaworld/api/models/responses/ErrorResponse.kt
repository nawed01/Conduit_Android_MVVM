package io.relaworld.api.models.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.relaworld.api.models.entities.Error

@JsonClass(generateAdapter = true)
data class ErrorResponse(
    @Json(name = "errors")
    val errors: Error
)