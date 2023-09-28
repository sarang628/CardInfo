package com.example.cardinfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
                    if (viewModel.uiState.value.restaurants.size > it) {
                        onChangePage?.invoke(viewModel.uiState.value.restaurants[it])
                        viewModel.setRestaurant(viewModel.uiState.value.restaurants[it].restaurantId)
                    }
                },
                onClickCard = onClickCard
            )
        }
        Button(onClick = {
            viewModel.selectRestaurant(337)
        }) {
        }
    }
}