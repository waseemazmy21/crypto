package com.example.crypto.di

import com.example.crypto.common.Constants
import com.example.crypto.data.remote.CoinApiService
import com.example.crypto.data.remote.dataSource.CoinRemoteDataSource
import com.example.crypto.data.remote.dataSource.CoinRemoteDataSourceImpl
import com.example.crypto.data.repository.CoinRepositoryImpl
import com.example.crypto.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCoinApi(): CoinApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRemoteDataSource(apiService: CoinApiService): CoinRemoteDataSource {
        return CoinRemoteDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(remoteDataSource: CoinRemoteDataSource): CoinRepository {
        return CoinRepositoryImpl(remoteDataSource)
    }
}