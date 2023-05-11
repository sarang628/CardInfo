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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun RestaurantCardInfo() {
// Display 10 items
    HorizontalPager(pageCount = 10) { page ->
        ElevatedCard(Modifier.height(200.dp)) {
            Box(Modifier.background(Color.LightGray)) {
                Column(
                    Modifier
                        .fillMaxHeight()
                        .padding(start = 8.dp, bottom = 8.dp)
                    ,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(text = "맥도날드", fontSize = 25.sp, color = Color.White)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        RatingBar(rating = 3.5f)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "3.0", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Text(text = "한식", color = Color.White)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "$$", color = Color.White)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "100m", color = Color.White)
                    }
                }
                AsyncImage(
                    model = "http://sarang628.iptime.org:88/2.png",
                    modifier = Modifier.fillMaxWidth(),
                    contentDescription = "",
                )
            }
        }
    }
}

@Composable
fun RatingBar(rating: Float) {
    Row() {
        for (f in 0..rating.toInt()) {
            Image(
                painter = painterResource(id = android.R.drawable.ic_lock_power_off),
                contentDescription = "",
                Modifier
                    .size(Dp(15f))
                    .padding(start = Dp(2f))
            )
        }
    }
}