package com.example.cardinfo

interface RestaurantCardService {
    suspend fun getCardList(): List<RestaurantCardData>
}