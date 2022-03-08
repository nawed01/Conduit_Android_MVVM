package io.realworld.api

import io.relaworld.api.ConduitClient
import io.relaworld.api.models.entities.LoginCreds
import io.relaworld.api.models.entities.UserCreds
import io.relaworld.api.models.requests.LoginRequest
import io.relaworld.api.models.requests.SignUpRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.random.Random

class ConduitClientTest {

    private val conduitClient = ConduitClient()

    @Test
    fun `POST user - create user`() {
        val userCreds =  UserCreds(
            "testemail${Random.nextInt(999,9999)}@test.com",
            "${Random.nextInt(9999,9999999)}",
            "rand_user${Random.nextInt(99,999)}"
        )
        runBlocking {
            val resp = conduitClient.api.signUpUser(SignUpRequest(userCreds))
            assertEquals(userCreds.username, resp.body()?.user?.username)
        }
    }

    @Test
    fun `POST user - login user`() {
        val loginCreds =  LoginCreds(
            "naruto007@gmail.com",
            "Nawed123"
        )
        runBlocking {
            val resp = conduitClient.api.loginUser(LoginRequest(loginCreds))
            assertEquals(loginCreds.email, resp.body()?.user?.email)
        }
    }

    @Test
    fun `GET articles`() {
        runBlocking {
            val articles = conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET articles by author`() {
        runBlocking {
            val articles = conduitClient.api.getArticles(author = "Naruto007")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET articles by tags`() {
        runBlocking {
            val articles = conduitClient.api.getArticles(tag = "welcome")
            assertNotNull(articles.body()?.articles)
        }
    }
}