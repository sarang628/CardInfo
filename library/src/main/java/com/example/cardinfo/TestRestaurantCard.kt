package com.example.cardinfo

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlin.random.Random

@Composable
fun TestRestaurantCard(
    viewModel: RestaurantCardViewModel,
    restaurantImageUrl: String,
    onChangePage: ((RestaurantCardData) -> Unit)? = null,
    onClickCard: (Int) -> Unit
) {
    Box {
        Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
            RestaurantCardPage(
                uiState = viewModel.uiState,
                restaurantImageUrl = restaurantImageUrl,
                onChangePage = {
                    Log.d("TestRestaurantCard", "pageChange : $it")
                    viewModel.onChangePage(it)
                },
                onClickCard = onClickCard
            )
        }
        Button(onClick = {
            viewModel.onChangePage(Random.nextInt(15))
        }) {
        }
    }
}