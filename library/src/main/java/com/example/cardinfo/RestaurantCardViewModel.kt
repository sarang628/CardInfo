package com.example.cardinfo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RestaurantCardViewModel(private val context: Context) : ViewModel() {

    val uiState = MutableStateFlow(RestaurantInfoCardUiState())

    init {
        viewModelScope.launch {
            uiState.emit(testRestaurantInfoCardUiState(context))
        }
    }

    fun selectRestaurant(id: Int) {
        viewModelScope.launch {
            uiState.emit(uiState.value.copy(
                currentPosition = uiState.value.restaurants.indexOf(RestaurantCardData(restaurantId = id))
            ))
        }
    }

    fun setRestaurnat(restaurantId: Int?) {
        uiState.value = uiState.value.copy(
            currentPosition = uiState.value.restaurants.indexOf(RestaurantCardData(restaurantId = restaurantId))
        )
    }
}