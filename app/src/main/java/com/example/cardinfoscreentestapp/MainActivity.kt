package com.example.cardinfoscreentestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cardinfo.RestaurantCardInfo
import com.example.cardinfoscreentestapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.cvCard.setContent {
            RestaurantCardInfo()
        }

        setContentView(binding.root)

    }
}