package com.sarang.torang.compose.cardinfo

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
private const val TAG = "__RestaurantCardPage"
@Composable
fun RestaurantCardPage(
    cardInfoViewModel   : CardInfoViewModel             = hiltViewModel(),
    onClickCard         : (Int) -> Unit                 = { Log.w(TAG, "onClickCard isn't set") },
    visible             : Boolean                       = false,
    onPosition          : (Double, Double) -> Unit      = { _,_ -> Log.w("__RestaurantCardPage", "onPosition is not set.") }) {
    RestaurantCardPage1(
        restaurants         = cardInfoViewModel.cardInfos,
        onChangePage        = { cardInfoViewModel.onChangePage(it) },
        visible             = visible,
        focusedRestaurant   = cardInfoViewModel.focusedRestaurant,
        onClickCard         = onClickCard,
        onPosition          = { lat, lon -> Log.i("__RestaurantCardPage", "onPosition : ${lat}, ${lon}"); onPosition.invoke(lat,lon) })
}

// @formatter:off
/**
 * @param onChangePage              카드 페이지 변경
 * @param restaurants               음식점 리스트
 * @param focusedRestaurant         포커스 음식점
 * @param onClickCard               카드 클릭 이벤트
 * @param visible                   카드 노출 여부
 * @param onPosition                위치 이동 클릭
 * @param positionColor             위치 아이콘 색상
 * @param positionColor             위치 아이콘 색상
 * @param positionBackgroundColor    위치 아이콘 배경 색상
 * @param progressTintColor         ratingBar 별 색상
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RestaurantCardPage1(
    onChangePage            : ((Int) -> Unit)               = {},
    restaurants             : List<RestaurantCardUIState>   = listOf(),
    focusedRestaurant       : RestaurantCardUIState?        = null,
    onClickCard             : (Int) -> Unit                 = {},
    visible                 : Boolean                       = false,
    onPosition              : ((Double, Double) -> Unit)    = {_,_ -> },
    positionColor           : Color?                        = null,
    positionBackgroundColor : Color?                        = null,
    progressTintColor       : Color?                        = null
) {
    val tag: String = "__RestaurantCardPage"
    val pageState = rememberPagerState(pageCount = { restaurants.size })
    val density = LocalDensity.current

    LaunchedEffect(pageState) {
        snapshotFlow { pageState.settledPage }.collect {
            if (pageState.targetPage == it) { onChangePage.invoke(it) } //애니메이션으로 움직이면 여러 페이지가 호출되어 보정
        }
    }

    LaunchedEffect(key1 = focusedRestaurant, block = {
        focusedRestaurant.let {
            pageState.animateScrollToPage(restaurants.indexOf(it), 0f)
        }
    })

    AnimatedVisibility(visible = visible, enter = slideInVertically { with(density) { 300.dp.roundToPx() } }, exit = slideOutVertically { with(density) { 300.dp.roundToPx() } }) {
        Column {
            if (restaurants.isNotEmpty()) { // 데이터가 없을 때도 onPageChange가 발생해 데이터가 있을때 그리도록 변경
                HorizontalPager(state = pageState) { page ->
                    RestaurantCard(uiState = restaurants[page], onClickCard = onClickCard, onPosition = onPosition, positionColor = positionColor)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewRestaurantCardPage() {
    RestaurantCardPage1(/*Preview*/
        restaurants = listOf(getTestRestaurantCardData().copy(restaurantName = "가나다라마바사아자차카타파아가나다라마바사아자차카타파하"),
                             getTestRestaurantCardData(),
                             getTestRestaurantCardData()),
        onClickCard = {},
        visible     = true
    )
}
// @formatter:on