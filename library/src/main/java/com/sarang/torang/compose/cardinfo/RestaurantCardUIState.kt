package com.sarang.torang.compose.cardinfo

/**
 * @param restaurantId 음식점 id
 * @param restaurantName 음식점 명
 * @param rating 평점
 * @param foodType 음식 종류
 * @param restaurantImage 음식점 이미지
 * @param price 가격대
 * @param distance 나와의 거리
 */
data class RestaurantCardUIState(
    val restaurantId: Int = 0,
    val restaurantName: String = "",
    val rating: Float = 0.0f,
    val foodType: String = "",
    val restaurantImage: String = "",
    val price: String = "",
    val distance: String = "",
    val lat : Double = 0.0,
    val lon : Double = 0.0
) {
    override fun equals(other: Any?): Boolean {
        if (other == null) return false

        if (other is RestaurantCardUIState)
            return other.restaurantId == this.restaurantId

        return false
    }
    companion object{
        val dummy : RestaurantCardUIState get() =  RestaurantCardUIState(restaurantId = 0, restaurantName = "맥도날드", rating = 3.0f, foodType = "한식", restaurantImage = "1/07_29_29_831/07_29_29_831.jpeg", price = "$$", distance = "100m")
    }
}

fun getTestRestaurantCardData(): RestaurantCardUIState {
    return RestaurantCardUIState(
        restaurantId = 0,
        restaurantName = "맥도날드",
        rating = 3.0f,
        foodType = "한식",
        restaurantImage = "/215/2024-08-19/11_36_21_980.jpg",
        price = "$$",
        distance = "100m"
    )
}

val RestaurantCardUIState.visibleFoodType: Boolean get() = foodType != "None"