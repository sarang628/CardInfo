package com.example.cardinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun RestaurantCard(
    restaurantImageUrl: String,
    restaurant: RestaurantCardData,
    onClickCard: (Int) -> Unit
) {
    ElevatedCard(
        Modifier
            .height(200.dp)
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            .clickable {
                onClickCard.invoke(restaurant.restaurantId)
            }
    ) {
        Box(Modifier.background(Color.LightGray)) {
            AsyncImage(
                model = restaurantImageUrl + restaurant.restaurantImage,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                contentDescription = "",
            )
            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp, bottom = 8.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = restaurant.restaurantName,
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    RatingBar(rating = restaurant.rating)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = restaurant.rating.toString(), color = Color.White)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(
                        text = restaurant.foodType,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = restaurant.price,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = restaurant.distance,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}