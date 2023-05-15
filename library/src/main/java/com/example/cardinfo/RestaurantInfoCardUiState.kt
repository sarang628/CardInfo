package com.example.cardinfo

import android.content.Context
import android.util.Log
import com.example.library.JsonToObjectGenerator
import com.example.library.data.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.streams.toList


/**
 * 맛집정보카드 UI 상태
 */
data class RestaurantInfoCardUiState(
    val currentPosition: Int = 0, // 현재 카드 위치
    val showCard: Boolean = false, // 카드 노출 여부
    val restaurants: List<RestaurantCardData> = ArrayList() // 현재 검색된 맛집리스트
)

fun testRestaurantInfoCardUiState(context: Context): StateFlow<RestaurantInfoCardUiState> {

    val list = JsonToObjectGenerator<Restaurant>().getListByFile(
        context = context,
        "restaurants1.json",
        Restaurant::class.java
    )

    Log.d("TAG", list.toString());

    val date = MutableStateFlow(RestaurantInfoCardUiState(
        restaurants = ArrayList<RestaurantCardData>().apply {
            addAll(list.stream().map { it.toRestaurantCard() }.toList())
        }
    ))
    return date
}

fun Restaurant.toRestaurantCard(): RestaurantCardData {
    return RestaurantCardData(
        restaurantId = restaurant_id,
        restaurantName = restaurant_name,
        rating = rating,
        foodType = restaurant_type,
        restaurantImage = img_url1,
        price = prices
    )
}

data class RestaurantCardData(
    val restaurantId: Int? = 0,
    val restaurantName: String? = null,
    val rating: Float? = null,
    val foodType: String? = null,
    val restaurantImage: String? = null,
    val price: String? = null,
    val distance: String? = "100m"
)

fun getTestRestaurnat(): RestaurantCardData {
    return RestaurantCardData(
        restaurantName = "맥도날드",
        rating = 3.0f,
        foodType = "한식",
        restaurantImage = "http://sarang628.iptime.org:88/restaurants/mcd.jpg",
        price = "$$",
        distance = "100m"
    )
}