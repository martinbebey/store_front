package com.developer.storefront.services

import com.developer.storefront.model.Product
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.*
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.http.URLBuilder
import io.ktor.http.takeFrom
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://fakestoreapi.com/"
const val END_POINT = "products"

class KtorApiClient {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        install(Logging) {
            level = LogLevel.ALL
        }
    }

    suspend fun getProducts(): List<Product> {
//        val url = URLBuilder().apply {
//            takeFrom(BASE_URL + END_POINT) // Replace with your API endpoint
//        }
        return httpClient.get(BASE_URL + END_POINT).body()
    }
}

//Retrofit
private val retrofit = Retrofit
    .Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val fetchService = retrofit.create(ApiService::class.java)

/**
 * Service for fetching the remote data list
 **/
interface ApiService{
    @GET(END_POINT)
    suspend fun getProductItems(): MutableList<Product>
}