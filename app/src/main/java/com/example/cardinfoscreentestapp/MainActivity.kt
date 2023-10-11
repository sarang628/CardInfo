package com.example.cardinfoscreentestapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfo.RestaurantCardPage
import com.example.cardinfo.RestaurantCardViewModel
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
                    Box {
                        Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
                            RestaurantCardPage(
                                uiState = viewModel.uiState,
                                restaurantImageUrl = "http://sarang628.iptime.org:89/restaurant_images/",
                                onChangePage = {},
                                onClickCard = { navController.navigate("detail") }
                            )
                        }
                        Button(onClick = {

                        }) {
                        }
                    }
                }
                composable("detail") {
                    Text(text = "test")
                }
            }
        }
    }
}