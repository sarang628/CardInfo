package com.example.cardinfoscreentestapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfo.RestaurantCardData
import com.example.cardinfo.RestaurantCardPage
import com.example.cardinfo.getTestRestaurantCardData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var visible by remember { mutableStateOf(false) }
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "cardInfo") {
                composable("cardInfo") {
                    Box {
                        Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
                            RestaurantCardPage(
                                restaurantImageUrl = "http://sarang628.iptime.org:89/restaurant_images/",
                                onChangePage = {},
                                onClickCard = { navController.navigate("detail") },
                                restaurants = ArrayList<RestaurantCardData>().apply {
                                    add(getTestRestaurantCardData())
                                    add(getTestRestaurantCardData())
                                    add(getTestRestaurantCardData())
                                    add(getTestRestaurantCardData())
                                    add(getTestRestaurantCardData())
                                },
                                visible = visible
                            )
                        }
                        Button(onClick = {
                            visible = !visible
                        }) {
                            Text(text = "hide")
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