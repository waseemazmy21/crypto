package com.example.crypto.data.remote

import retrofit2.http.GET

interface CoinApiService {
    @GET("/v1/coins")
    suspend fun getCoins()
}