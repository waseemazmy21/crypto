package com.example.crypto.presentation.ui.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.common.Resource
import com.example.crypto.domain.use_case.GetCoinByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinByIdUseCase: GetCoinByIdUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init{
        val coinId: String? = savedStateHandle["id"]
        coinId?.let { getCoin(it) }
    }

    private fun getCoin(id: String) {
        getCoinByIdUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailsState(coin = result.data)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailsState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}