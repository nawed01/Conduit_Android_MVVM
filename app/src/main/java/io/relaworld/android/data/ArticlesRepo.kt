package io.relaworld.android.data

import io.relaworld.api.ConduitClient

object ArticlesRepo {

    val api = ConduitClient().api

    suspend fun getGlobalFeed() = api.getArticles()

}