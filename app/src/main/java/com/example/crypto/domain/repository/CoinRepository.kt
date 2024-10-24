package com.example.crypto.domain.repository

import com.example.crypto.domain.model.Coin
import com.example.crypto.domain.model.CoinDetails

interface CoinRepository {
    suspend fun getCoins(): List<Coin>
    suspend fun getCoinById(id: String): CoinDetails
}