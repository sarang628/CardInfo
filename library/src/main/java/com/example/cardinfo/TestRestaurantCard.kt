package com.example.cardinfo

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TestRestaurantCard(context: Context, onChangePage: ((RestaurantCardData) -> Unit)? = null) {
    val viewModel = RestaurantCardViewModel(context)
    Box {
        Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
            RestaurantCardPage(viewModel.uiState, onChangePage = {
                onChangePage?.invoke(viewModel.uiState.value.restaurants[it])
                viewModel.setRestaurnat(viewModel.uiState.value.restaurants[it].restaurantId)
            })
        }
        Button(onClick = {
            viewModel.selectRestaurant(337)
        }) {
        }
    }
}