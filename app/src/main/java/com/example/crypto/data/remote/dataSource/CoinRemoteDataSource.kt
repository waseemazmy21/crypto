package com.example.crypto.data.remote.dataSource

import com.example.crypto.data.remote.dto.CoinDetailsDto
import com.example.crypto.data.remote.dto.CoinDto

interface CoinRemoteDataSource {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(id: String): CoinDetailsDto
}