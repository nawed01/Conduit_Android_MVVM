package io.realworld.api

import io.relaworld.api.ConduitClient
import org.junit.Assert.assertNotNull
import org.junit.Test

class ConduitClientTest {

    private val conduitClient = ConduitClient()

    @Test
    fun `GET articles`() {
        val articles = conduitClient.api.getArticles().execute()
        assertNotNull(articles.body()?.articles)
    }
}