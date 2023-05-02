package com.example.cardinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 맛집정보카드 뷰모델 입니다.
 */
@OptIn(InternalCoroutinesApi::class)
@HiltViewModel
class RestaurantInfoCardViewModel @Inject constructor(
) : ViewModel() {
    private val _uiState = MutableStateFlow(RestaurantInfoCardUiState())
    val uiState: StateFlow<RestaurantInfoCardUiState> = _uiState

    init {
        viewModelScope.launch {
            // 현재 포커스된 맛집 위치
            /*findRepository.getCurrentPosition().collectLatest { position ->
                _uiState.update {
                    it.copy(currentPosition = position)
                }
            }*/
        }

        viewModelScope.launch {
            // 맵 클릭 감지
            //카드 보여줄지 여부
            /*findRepository.showRestaurantCardAndFilter().collectLatest { showCard ->
                _uiState.update {
                    it.copy(showCard = showCard)
                }
            }*/
        }

        viewModelScope.launch {
            // 검색된 맛집 리스트
            /*findRepository.getSearchedRestaurant().collect(FlowCollector{ restaurants ->
                _uiState.update {
                    it.copy(restaurants = restaurants)
                }
            })*/
        }
    }
}