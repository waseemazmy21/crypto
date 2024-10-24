package com.example.crypto.data.remote.dataSource

import com.example.crypto.data.remote.CoinApiService
import com.example.crypto.data.remote.dto.CoinDetailsDto
import com.example.crypto.data.remote.dto.CoinDto

class CoinRemoteDataSourceImpl(private val api: CoinApiService): CoinRemoteDataSource {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailsDto {
        return api.getCoinById(id)
    }
}