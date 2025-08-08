package com.sarang.torang.usecase.cardinfo

interface SetRestaurantUseCase {
    suspend fun invoke(restaurantId : Int)
}