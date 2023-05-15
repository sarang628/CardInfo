package com.example.cardinfo

import android.content.Context
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TestRestaurantCard(context: Context) {
    val d = testRestaurantInfoCardUiState(context)
    Box {
        Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
            RestaurantCardPage(d, onChangePage = {
                Log.d("sryang123", it.toString())
            })
        }
    }
}