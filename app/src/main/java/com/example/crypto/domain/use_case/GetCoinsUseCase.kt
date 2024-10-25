package com.example.crypto.domain.use_case

import com.example.crypto.common.Resource
import com.example.crypto.domain.model.Coin
import com.example.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinsUseCase(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins()
            emit(Resource.Success(coins))
        } catch (error: IOException) {
            emit(Resource.Error("No internet connection. Please check your network and try again."))
        } catch (error: HttpException) {
            emit(Resource.Error("An unexpected error occurred"))
        }
    }
}