package com.example.cardinfo

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RestaurantCardPage(
    onChangePage: ((Int) -> Unit)? = null,
    restaurants: List<RestaurantCardData>? = null, // 현재 검색된 맛집리스트
    selectedRestaurant: RestaurantCardData? = null, // 현재 선택된 맛집
    restaurantImageUrl: String,
    onClickCard: (Int) -> Unit,
    visible: Boolean
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
        Log.d("RestaurantCardPage", selectedRestaurant.toString())
        selectedRestaurant?.let {
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
    }


}