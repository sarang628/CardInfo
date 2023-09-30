package com.example.cardinfo

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RestaurantCardPage(
    uiState: StateFlow<RestaurantInfoCardUiState>,
    onChangePage: ((Int) -> Unit)? = null,
    restaurantImageUrl: String,
    onClickCard: (Int) -> Unit
) {
    val pageState = rememberPagerState()

    LaunchedEffect(pageState) {
        snapshotFlow { pageState.currentPage }.collect {
            if (pageState.targetPage == it) {
                //애니메이션으로 움직이면 여러페이지가 호출되어 보정
                onChangePage?.invoke(it)
            }

        }
    }

    rememberCoroutineScope().launch {
        uiState.value.currentPosition?.let {
            pageState.animateScrollToPage(it, 0f)
        }
    }

    val state by uiState.collectAsState()
    val restaurants = state.restaurants
    if (!restaurants.isNullOrEmpty()) {
        HorizontalPager(
            pageCount = restaurants.size,
            state = pageState,

            ) { page ->
            RestaurantCard(
                restaurant = restaurants[page],
                restaurantImageUrl = restaurantImageUrl,
                onClickCard = onClickCard
            )
        }
    }
}