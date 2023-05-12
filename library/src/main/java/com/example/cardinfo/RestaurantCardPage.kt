package com.example.cardinfo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.Text
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun RestaurantCardPage(uiState: StateFlow<RestaurantInfoCardUiState>) {
// Display 10 items
    val state by uiState.collectAsState()
    HorizontalPager(pageCount = state.restaurants.size) { page ->
        RestaurantCard(restaurant = state.restaurants[page])
    }
}

@Composable
fun RatingBar(rating: Float) {
    Row() {
        for (f in 0..rating.toInt()) {
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "",
                Modifier
                    .size(Dp(15f))
                    .padding(start = Dp(2f))
            )
        }
    }
}

@Composable
fun RestaurantCard(restaurant: Restaurant) {
    ElevatedCard(
        Modifier
            .height(200.dp)
            .padding(start = 4.dp, end = 4.dp, top = 4.dp)
    ) {
        Box(Modifier.background(Color.LightGray)) {
            AsyncImage(
                model = restaurant.restaurantImage,
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
                    text = restaurant.restaurantName ?: "",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    RatingBar(rating = restaurant.rating?:0f)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = restaurant.rating.toString() ?: "0", color = Color.White)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(text = restaurant.foodType?:"", color = Color.White, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = restaurant.price?:"", color = Color.White, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = restaurant.distance?:"", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}