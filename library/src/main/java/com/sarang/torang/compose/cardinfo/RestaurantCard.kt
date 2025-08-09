package com.sarang.torang.compose.cardinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

// @formatter:off
/**
 * @param progressTintColor ratingBar 별 색상
 */
@Composable
fun RestaurantCard(restaurant: RestaurantCardUIState, onClickCard: (Int) -> Unit = {}, onPosition: ((Double, Double) -> Unit) = {_,_ -> }, positionColor: Color? = null, positionBackroundColor: Color? = null, progressTintColor: Color? = null) {
    val interactionSource = remember { MutableInteractionSource() }
    ElevatedCard(modifier = Modifier.height(220.dp).padding(start = 8.dp, end = 8.dp, bottom = 8.dp).clickable(interactionSource = interactionSource, indication = null) { onClickCard.invoke(restaurant.restaurantId) }, elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)) {
        Box(Modifier.background(Color.LightGray)) {
            ConstraintLayout(constraintSet = restaurantCardConstraintSet()) {
                LocalCardInfoImageLoader.current.invoke(Modifier.fillMaxSize(), restaurant.restaurantImage, 30.dp, 30.dp, ContentScale.Crop)
                IconButton(modifier = Modifier.layoutId("btnPosition").clip(CircleShape).background(Color.White).align(Alignment.BottomEnd),
                    onClick = { onPosition.invoke(restaurant.lat, restaurant.lon) }) {
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = "", tint = positionColor ?: MaterialTheme.colorScheme.primary)
                }

                ConstraintLayout(modifier = Modifier.layoutId("infoContainer").align(Alignment.BottomStart).clip(RoundedCornerShape(8.dp)).background(Color(0x55000000)).padding(8.dp), constraintSet = restaurantCardInfoConstraintSet()) {
                    Text(modifier = Modifier.layoutId("restaurantName"), text = restaurant.restaurantName, fontSize = 25.sp, color = Color.White, maxLines = 1, overflow = TextOverflow.Clip, fontWeight = FontWeight.Bold)
                    AndroidViewRatingBar(modifier = Modifier.layoutId("ratingBar"), rating = restaurant.rating, isSmall = true, progressTintColor = progressTintColor)
                    Text(modifier = Modifier.layoutId("ratingTxt"), text = restaurant.rating.toString(), color = Color.White)
                    Text(modifier = Modifier.layoutId("foodType"), text = restaurant.foodType, color = Color.White, fontWeight = FontWeight.Bold)
                    Text(modifier = Modifier.layoutId("price"), text = restaurant.price, color = Color.White, fontWeight = FontWeight.Bold)
                    Text(modifier = Modifier.layoutId("distance"), text = restaurant.distance, color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

internal fun restaurantCardConstraintSet(): ConstraintSet {
    return ConstraintSet {
        val infoContainer = createRefFor("infoContainer")
        val btnPosition = createRefFor("btnPosition")
        constrain(infoContainer) { bottom.linkTo(parent.bottom, 8.dp); start.linkTo(parent.start, 8.dp); end.linkTo(btnPosition.start, 8.dp); width = Dimension.fillToConstraints }
        constrain(btnPosition) { bottom.linkTo(parent.bottom, 8.dp); end.linkTo(parent.end, 8.dp) }
    }
}

internal fun restaurantCardInfoConstraintSet(): ConstraintSet {
    return ConstraintSet {
        val restaurantName = createRefFor("restaurantName")
        val ratingBar = createRefFor("ratingBar")
        val ratingTxt = createRefFor("ratingTxt")
        val foodType = createRefFor("foodType")
        val price = createRefFor("price")
        val distance = createRefFor("distance")

        constrain(ratingBar) { top.linkTo(restaurantName.bottom) }
        constrain(ratingTxt) { top.linkTo(ratingBar.top);bottom.linkTo(ratingBar.bottom);start.linkTo(ratingBar.end, margin = 4.dp)}
        constrain(foodType) { top.linkTo(ratingBar.bottom) }
        constrain(price) { top.linkTo(foodType.top);bottom.linkTo(foodType.bottom);start.linkTo(foodType.end, margin = 2.dp) }
        constrain(distance) { top.linkTo(foodType.top);bottom.linkTo(foodType.bottom);start.linkTo(price.end, margin = 2.dp); }
    }
}

@Preview
@Composable
fun PreviewRestaurantCard() {
    Column {
        RestaurantCard(restaurant = getTestRestaurantCardData().copy(restaurantName = ""), onClickCard = {})
        ElevatedCard(Modifier.fillMaxWidth().height(200.dp)) {}
    }
}
// @formatter:on