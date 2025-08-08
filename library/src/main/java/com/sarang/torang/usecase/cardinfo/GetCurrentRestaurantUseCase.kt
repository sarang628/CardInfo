package com.sarang.torang.usecase.cardinfo

import com.sarang.torang.compose.cardinfo.RestaurantCardUIState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

interface GetCurrentRestaurantUseCase {
    fun invoke(coroutineScope: CoroutineScope) : StateFlow<RestaurantCardUIState>
}