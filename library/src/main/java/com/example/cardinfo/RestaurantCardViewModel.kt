package com.example.cardinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.streams.toList

@HiltViewModel
class RestaurantCardViewModel @Inject constructor() : ViewModel() {
    val _uiState = MutableStateFlow(RestaurantInfoCardUiState())
    val uiState = _uiState.asStateFlow()
}