package com.example.cardinfo

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RestaurantCardPage(
    onChangePage: ((Int) -> Unit)? = null,          // 카드 페이지 변경
    restaurants: List<RestaurantCardData>? = null,  // 현재 검색된 음식점 리스트
    focusedRestaurant: RestaurantCardData? = null,  // 현재 포커스 된 음식점
    restaurantImageServerUrl: String,               // 이미지 서버 url
    onClickCard: (Int) -> Unit,                     // 카드 클릭 이벤트
    visible: Boolean                                // 카드 노출 여부
) {
    val TAG: String = "_RestaurantCardPage"
    val pageState = rememberPagerState(pageCount = { restaurants?.size ?: 0 })

    LaunchedEffect(pageState) {

        snapshotFlow { pageState.settledPage }.collect {
            Log.d(TAG, "currentPage=$it")
            Log.d(TAG, "targetPage=${pageState.targetPage}")
            Log.d(TAG, "settledPage=${pageState.settledPage}")
            Log.d(TAG, "isScrollInProgress=${pageState.isScrollInProgress}")
            if (pageState.targetPage == it) {
                //애니메이션으로 움직이면 여러 페이지가 호출되어 보정
                onChangePage?.invoke(it)
            }
        }
    }

    LaunchedEffect(key1 = focusedRestaurant, block = {
        Log.d(TAG, focusedRestaurant.toString())
        focusedRestaurant?.let {
            val index = restaurants?.indexOf(it)

            if (index != null)
                pageState.animateScrollToPage(index, 0f)
        }
    })

    val density = LocalDensity.current
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically { with(density) { 200.dp.roundToPx() } },
        exit = slideOutVertically { with(density) { 200.dp.roundToPx() } }
    ) {
        Column {
            // 데이터가 없을 때도 onPageChange가 발생해 데이터가 있을때 그리도록 변경
            if (!restaurants.isNullOrEmpty()) {
                HorizontalPager(
                    state = pageState,
                ) { page ->
                    RestaurantCard(
                        restaurant = restaurants[page],
                        restaurantImageUrl = restaurantImageServerUrl,
                        onClickCard = onClickCard
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewRestaurantCardPage() {
    RestaurantCardPage(
        onChangePage = {},
        restaurants = listOf(
            getTestRestaurantCardData(),
            getTestRestaurantCardData(),
            getTestRestaurantCardData()
        ),
        onClickCard = {},
        restaurantImageServerUrl = "http://sarang628.iptime.org:89/restaurant_images/",
        visible = true
    )
}