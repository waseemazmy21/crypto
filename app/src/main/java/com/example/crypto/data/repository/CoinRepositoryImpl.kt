package com.example.crypto.data.repository

import com.example.crypto.data.remote.dataSource.CoinRemoteDataSource
import com.example.crypto.data.remote.dto.toCoin
import com.example.crypto.data.remote.dto.toCoinDetails
import com.example.crypto.domain.model.Coin
import com.example.crypto.domain.model.CoinDetails
import com.example.crypto.domain.repository.CoinRepository

class CoinRepositoryImpl(private val coinRemoteDataSource: CoinRemoteDataSource): CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return coinRemoteDataSource.getCoins().map { it.toCoin() }
    }

    override suspend fun getCoinById(id: String): CoinDetails {
        return coinRemoteDataSource.getCoinById(id).toCoinDetails()
    }
}