package com.example.cardinfo

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RestaurantCardPage(
    uiState: StateFlow<RestaurantInfoCardUiState>,
    onChangePage: ((Int) -> Unit)? = null,
    restaurants: List<RestaurantCardData>? = null, // 현재 검색된 맛집리스트
    selectedRestaurant: RestaurantCardData? = null, // 현재 선택된 맛집
    restaurantImageUrl: String,
    onClickCard: (Int) -> Unit
) {
    val pageState = rememberPagerState()

    LaunchedEffect(pageState) {

        snapshotFlow { pageState.settledPage }.collect {
            Log.d("RestaurantCardPage", "currentPage=$it")
            Log.d("RestaurantCardPage", "targetPage=${pageState.targetPage}")
            Log.d("RestaurantCardPage", "settledPage=${pageState.settledPage}")
            Log.d("RestaurantCardPage", "isScrollInProgress=${pageState.isScrollInProgress}")
            if (pageState.targetPage == it) {
                //애니메이션으로 움직이면 여러페이지가 호출되어 보정
                onChangePage?.invoke(it)
            }
        }
    }

    LaunchedEffect(key1 = selectedRestaurant, block = {
        selectedRestaurant?.let {
            val index = restaurants?.indexOf(it)

            if (index != null)
                pageState.animateScrollToPage(index, 0f)
        }
    })


    // 데이터가 없을 때도 onPageChange가 발생해 데이터가 있을때 그리도록 변경
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