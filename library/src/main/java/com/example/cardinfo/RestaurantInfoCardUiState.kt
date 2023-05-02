package com.example.cardinfo

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.concurrent.Flow


/**
 * 맛집정보카드 UI 상태
 */
data class RestaurantInfoCardUiState(
    val currentPosition: Int = 0, // 현재 카드 위치
    val showCard: Boolean = false, // 카드 노출 여부
    val restaurants: List<Restaurant> = ArrayList() // 현재 검색된 맛집리스트
)

fun testRestaurantInfoCardUiState(): StateFlow<RestaurantInfoCardUiState> {
    val date = MutableStateFlow(RestaurantInfoCardUiState(
        restaurants = ArrayList<Restaurant>().apply {
            add(Restaurant(restaurantName = "맥도날드"))
        }
    ))
    return date
}