package com.example.crypto.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crypto.presentation.ui.coin_details.CoinDetailsScreen
import com.example.crypto.presentation.ui.coin_list.CoinListScreen
import com.example.crypto.ui.theme.CryptoTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { contentPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = "coinsList",
                            modifier = Modifier.padding(contentPadding)
                        ) {
                            composable(route = "coinsList") {
                                CoinListScreen(navController = navController)
                            }

                            composable(route = "coinDetails/{id}") {
                                    CoinDetailsScreen()
                            }
                        }
                    }
                )
            }
        }
    }
}
