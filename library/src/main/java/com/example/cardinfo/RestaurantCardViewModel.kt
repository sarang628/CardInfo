package com.example.cardinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.streams.toList

@HiltViewModel
class RestaurantCardViewModel @Inject constructor(
    private val restaurantCardService: RestaurantCardService
) : ViewModel() {

    val uiState = MutableStateFlow(RestaurantInfoCardUiState())

    init {
        viewModelScope.launch {
            uiState.emit(
                uiState.value.copy(
                    restaurants = restaurantCardService.getCardList()
                )
            )
        }
    }

    fun selectRestaurant(id: Int) {
        viewModelScope.launch {
            val selectData =
                uiState.value.restaurants.stream().filter { it.restaurantId == id }.toList()
            if (selectData.size == 1) {
                uiState.emit(
                    uiState.value.copy(
                        currentPosition = uiState.value.restaurants.indexOf(
                            selectData[0]
                        )
                    )
                )
            }
        }
    }

    fun setRestaurant(restaurantId: Int) {
        val selectData =
            uiState.value.restaurants.stream().filter { it.restaurantId == restaurantId }.toList()
        if (selectData.size != 1)
            return;

        uiState.value = uiState.value.copy(
            currentPosition = uiState.value.restaurants.indexOf(selectData[0])
        )
    }
}