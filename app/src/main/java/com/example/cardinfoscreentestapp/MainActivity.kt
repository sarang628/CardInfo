package com.example.cardinfoscreentestapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.Modifier
import com.example.cardinfo.RestaurantCardPage
import com.example.cardinfo.testRestaurantInfoCardUiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val d = testRestaurantInfoCardUiState(this)
        setContent {
            Box {
                Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
                    RestaurantCardPage(d)
                }
            }
        }

    }
}