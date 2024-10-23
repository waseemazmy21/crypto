package com.example.crypto.data.remote

import com.example.crypto.data.remote.dto.CoinDetailsDto
import com.example.crypto.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApiService {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/id")
    suspend fun getCoin(@Path("id") id:String): CoinDetailsDto
}