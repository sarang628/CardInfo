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

fun testRestaurantInfoCardUiState(context: Context): RestaurantInfoCardUiState {

    val list = JsonToObjectGenerator<RestaurantCardData>().getListByFile(
        context = context,
        "restaurants1.json",
        Restaurant::class.java
    )

    Log.d("TAG", list.toString());

    val date = RestaurantInfoCardUiState(
        restaurants = ArrayList<RestaurantCardData>().apply {
            addAll(list)
        }
    )

    return date
}

data class RestaurantCardData(
    val restaurantId: Int,
    val restaurantName: String,
    val rating: Float,
    val foodType: String,
    val restaurantImage: String,
    val price: String,
    val distance: String
) {
    override fun equals(other: Any?): Boolean {
        return (other as RestaurantCardData).restaurantId == this.restaurantId
    }
}

fun getTestRestaurnat(): RestaurantCardData {
    return RestaurantCardData(
        restaurantId = 0,
        restaurantName = "맥도날드",
        rating = 3.0f,
        foodType = "한식",
        restaurantImage = "http://sarang628.iptime.org:88/restaurants/mcd.jpg",
        price = "$$",
        distance = "100m"
    )
}