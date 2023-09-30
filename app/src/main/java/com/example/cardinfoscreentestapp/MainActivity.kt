package com.example.cardinfoscreentestapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfo.RestaurantCardViewModel
import com.example.cardinfo.TestRestaurantCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: RestaurantCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "cardInfo") {
                composable("cardInfo") {
                    TestRestaurantCard(
                        viewModel = viewModel,
                        restaurantImageUrl = "http://sarang628.iptime.org:89/restaurant_images/",
                        onClickCard = {
                            navController.navigate("detail")
                        }
                    )
                }
                composable("detail") {
                    Text(text = "test")
                }
            }
        }
    }
}