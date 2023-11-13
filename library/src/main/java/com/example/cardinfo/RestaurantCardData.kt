package com.example.cardinfo
data class RestaurantCardData(
    val restaurantId: Int,          // 음식점 id
    val restaurantName: String,     // 음식점 명
    val rating: Float,              // 평점
    val foodType: String,           // 음식 종류
    val restaurantImage: String,    // 음식점 이미지
    val price: String,              // 가격대
    val distance: String            // 나와의 거리
) {
    override fun equals(other: Any?): Boolean {
        return (other as RestaurantCardData).restaurantId == this.restaurantId
    }
}

fun getTestRestaurantCardData(): RestaurantCardData {
    return RestaurantCardData(
        restaurantId = 0,
        restaurantName = "맥도날드",
        rating = 3.0f,
        foodType = "한식",
        restaurantImage = "1/07_29_29_831/07_29_29_831.jpeg",
        price = "$$",
        distance = "100m"
    )
}