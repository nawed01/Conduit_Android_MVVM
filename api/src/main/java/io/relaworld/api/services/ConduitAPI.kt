package io.relaworld.api.services

import io.relaworld.api.models.ArticleResponse
import io.relaworld.api.models.ArticlesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ConduitAPI {

    @GET("articles")
    fun getArticles():Call<ArticlesResponse>

}