package com.example.crypto.presentation.ui.coin_list

import com.example.crypto.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val coins: List<Coin> = emptyList()
)
