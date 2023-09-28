package com.example.cardinfoscreentestapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cardinfo.RestaurantCardViewModel
import com.example.cardinfo.TestRestaurantCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: RestaurantCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestRestaurantCard(viewModel, restaurantImageUrl = "http://sarang628.iptime.org:89/restaurant_images/", onClickCard = {
                Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_SHORT).show()
            })
        }
    }
}