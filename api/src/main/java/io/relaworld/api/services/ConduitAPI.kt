package io.relaworld.api.services

import io.relaworld.api.models.entities.LoginCreds
import io.relaworld.api.models.entities.User
import io.relaworld.api.models.entities.UserCreds
import io.relaworld.api.models.requests.LoginRequest
import io.relaworld.api.models.requests.SignUpRequest
import io.relaworld.api.models.responses.ArticlesResponse
import io.relaworld.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ConduitAPI {

    @POST("users")
    suspend fun signUpUser(
        @Body signUpRequest: SignUpRequest
    ): Response<UserResponse>

    @POST("users/login")
    suspend fun loginUser(
        @Body loginRequest: LoginRequest
    ): Response<UserResponse>


    @GET("articles")
    suspend fun getArticles(
        @Query("author") author: String? = null,
        @Query("favorited") favorited: String? = null,
        @Query("tag") tag: String? = null
    ):Response<ArticlesResponse> // suspend make this run on background thread using coroutines

}