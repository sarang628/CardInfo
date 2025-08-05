package com.sarang.torang

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.compose.cardinfo.CardInfoImageLoader
import com.sarang.torang.compose.cardinfo.LocalCardInfoImageLoader
import com.sarang.torang.compose.cardinfo.RestaurantCardData
import com.sarang.torang.compose.cardinfo.RestaurantCardPage1
import com.sarang.torang.compose.cardinfo.getTestRestaurantCardData
import com.sarang.torang.di.image.provideTorangAsyncImage
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
                        Column(
                            Modifier.Companion.fillMaxHeight(),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            CompositionLocalProvider(LocalCardInfoImageLoader provides customImageLoader) {
                                RestaurantCardPage1(
                                    onClickCard = { navController.navigate("detail") },
                                    restaurants = ArrayList<RestaurantCardData>().apply { add(getTestRestaurantCardData1());add(getTestRestaurantCardData1());add(getTestRestaurantCardData1());add(getTestRestaurantCardData1());add(getTestRestaurantCardData1()) },
                                    visible = visible,
                                )
                            }
                        }
                        Button(onClick = { visible = !visible }) { Text(text = "hide") }
                    }
                }
                composable("detail") { Text(text = "test") }
            }
        }
    }

    val customImageLoader: CardInfoImageLoader = { modifier, url, width, height, scale ->
        // 여기서 실제 이미지 로딩 구현 예시
        provideTorangAsyncImage().invoke(modifier, url, width, height, scale)
    }

    fun getTestRestaurantCardData1(): RestaurantCardData {
        val data = getTestRestaurantCardData()
        return data.copy(restaurantImage = BuildConfig.RESTAURANT_IMAGE_SERVER_URL + data.restaurantImage)
    }
}