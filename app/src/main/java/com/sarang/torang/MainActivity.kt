package com.sarang.torang

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.material.color.MaterialColors
import com.sarang.torang.compose.cardinfo.CardInfoImageLoader
import com.sarang.torang.compose.cardinfo.LocalCardInfoImageLoader
import com.sarang.torang.compose.cardinfo.RestaurantCardUIState
import com.sarang.torang.compose.cardinfo.RestaurantCardPage
import com.sarang.torang.compose.cardinfo.getTestRestaurantCardData
import com.sarang.torang.data.RestaurantWithFiveImages
import com.sarang.torang.di.image.provideTorangAsyncImage
import com.sarang.torang.di.repository.FindRepositoryImpl
import com.sryang.torang.ui.TorangTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var findRepository : FindRepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Test()
                }
            }
        }
    }

    @Composable
    fun Test(){

        var visible by remember { mutableStateOf(false) }
        val coroutineScope = rememberCoroutineScope()
        val navController = rememberNavController()
        var restaurants : List<RestaurantWithFiveImages> by remember { mutableStateOf(listOf()) }
        LaunchedEffect(Unit) {
            findRepository.restaurants.stateIn(scope = coroutineScope).collect {
                restaurants = it
            }
        }
        val selectedRestaurant = findRepository.selectedRestaurant.collectAsState().value
        val state: LazyListState = rememberLazyListState()

        LaunchedEffect(selectedRestaurant) {
            findRepository.restaurants.collect { list ->
                list.forEachIndexed { index, restaurant ->
                    if (restaurant.restaurant.restaurantId == selectedRestaurant.restaurant.restaurantId) {
                        state.animateScrollToItem(index)
                    }
                }
            }
        }

        Scaffold {
            NavHost(modifier = Modifier.padding(it), navController = navController, startDestination = "cardInfo") {
                composable("cardInfo") {
                    Box {
                        Column(modifier = Modifier.Companion.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
                            LazyColumn(modifier = Modifier.height(400.dp), state = state) {
                                items(restaurants.size) {
                                    TextButton({ coroutineScope.launch { restaurants[it].restaurant.restaurantId.let{findRepository.selectRestaurant(it)} } }) {
                                        Text((restaurants[it].restaurant.restaurantName))
                                    }
                                }
                            }
                            CompositionLocalProvider(LocalCardInfoImageLoader provides customImageLoader) {
                                RestaurantCardPage(
                                    onClickCard = { navController.navigate("detail") },
                                    visible = visible
                                )
                            }
                        }
                        Row {
                            Button(onClick = { visible = !visible }) { Text(text = if(visible) "hide" else "show") }
                            Button(onClick = { coroutineScope.launch { findRepository.findFilter() } }) { Text(text = "get Restaurants") }
                        }
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

    fun getTestRestaurantCardData1(): RestaurantCardUIState {
        val data = getTestRestaurantCardData()
        return data.copy(restaurantImage = BuildConfig.RESTAURANT_IMAGE_SERVER_URL + data.restaurantImage)
    }
}