package com.example.cardinfoscreentestapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.cardinfo.RestaurantCardPage
import com.example.cardinfo.testRestaurantInfoCardUiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val d = testRestaurantInfoCardUiState(this)
        setContent{
            RestaurantCardPage(d)
        }

    }
}