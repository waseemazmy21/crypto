package com.example.crypto.presentation.ui.coin_details

import com.example.crypto.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val coin: CoinDetails? = null
)
