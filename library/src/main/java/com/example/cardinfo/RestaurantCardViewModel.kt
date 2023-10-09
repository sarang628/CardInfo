package com.example.cardinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.streams.toList

@HiltViewModel
class RestaurantCardViewModel @Inject constructor(
    private val restaurantCardService: RestaurantCardService
) : ViewModel() {

    val _uiState = MutableStateFlow(RestaurantInfoCardUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.emit(
                uiState.value.copy(
                    restaurants = restaurantCardService.getCardList()
                )
            )
        }
    }

    fun selectRestaurant(id: Int) {
        val restaurants = uiState.value.restaurants ?: return

        viewModelScope.launch {
            val selectData =
                restaurants.stream().filter { it.restaurantId == id }.toList()
            if (selectData.size == 1) {
                _uiState.emit(
                    uiState.value.copy(
                        currentPosition = restaurants.indexOf(
                            selectData[0]
                        )
                    )
                )
            }
        }
    }

    fun setRestaurant(restaurantId: Int) {
        val restaurants = uiState.value.restaurants ?: return;
        val selectData = restaurants.stream().filter { it.restaurantId == restaurantId }.toList()
        if (selectData.size != 1)
            return;

        onChangePage(
            restaurants.indexOf(selectData[0])
        )
    }

    fun setRestaurantByMapMarker(restaurantId: Int){
        val restaurants = uiState.value.restaurants ?: return;
        val selectData = restaurants.stream().filter { it.restaurantId == restaurantId }.toList()
        if (selectData.size != 1)
            return;

        onChangePage(
            restaurants.indexOf(selectData[0])
        )
    }

    fun onChangePage(position: Int) {
        viewModelScope.launch {
            _uiState.emit(
                uiState.value.copy(
                    currentPosition = position
                )
            )
        }
    }
}