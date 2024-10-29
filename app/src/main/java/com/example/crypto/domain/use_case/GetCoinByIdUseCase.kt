package com.example.crypto.domain.use_case

import com.example.crypto.common.Resource
import com.example.crypto.domain.model.CoinDetails
import com.example.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinByIdUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(id: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(id)
            emit(Resource.Success(coin))
        } catch (error: IOException) {
            emit(Resource.Error("No internet connection. Please check your network and try again."))
        } catch (error: HttpException) {
            emit(Resource.Error("An unexpected error occurred"))
        }
    }
}