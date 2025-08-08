package com.sarang.torang.compose.cardinfo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarang.torang.usecase.cardinfo.GetCurrentRestaurantUseCase
import com.sarang.torang.usecase.cardinfo.GetRestaurantUseCase
import com.sarang.torang.usecase.cardinfo.SetRestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardInfoViewModel @Inject constructor(
    val getRestaurantUseCase: GetRestaurantUseCase,
    val getCurrentRestaurantUseCase : GetCurrentRestaurantUseCase,
    val setRestaurantUseCase : SetRestaurantUseCase
) : ViewModel() {
    var cardInfos: List<RestaurantCardUIState> by mutableStateOf(listOf())
        private set

    var focusedRestaurant: RestaurantCardUIState by mutableStateOf(RestaurantCardUIState())
        private set

    init {
        viewModelScope.launch {
            launch { getRestaurantUseCase.invoke(viewModelScope).collect { cardInfos = it } }
            launch { getCurrentRestaurantUseCase.invoke(viewModelScope).collect { focusedRestaurant = it } }
        }
    }

    fun onChangePage(index: Int) {
        if(index < cardInfos.size){
            viewModelScope.launch {
                setRestaurantUseCase.invoke(cardInfos.get(index).restaurantId)
            }
        }
    }
}