package com.example.cardinfo;

import java.lang.System;

/**
 * 맛집정보카드 뷰모델 입니다.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.OptIn(markerClass = {kotlinx.coroutines.InternalCoroutinesApi.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/example/cardinfo/RestaurantInfoCardViewModel;", "Landroidx/lifecycle/ViewModel;", "mapRepository", "Lcom/example/torang_core/repository/MapRepository;", "findRepository", "Lcom/example/torang_core/repository/FindRepository;", "(Lcom/example/torang_core/repository/MapRepository;Lcom/example/torang_core/repository/FindRepository;)V", "_clickCardInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/torang_core/util/Event;", "Lcom/example/torang_core/data/model/Restaurant;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/cardinfo/RestaurantInfoCardUiState;", "clickCardInfo", "Landroidx/lifecycle/LiveData;", "getClickCardInfo", "()Landroidx/lifecycle/LiveData;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clickRestaurant", "", "restaurantData", "setCurrentPosition", "position", "", "library_debug"})
public final class RestaurantInfoCardViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.torang_core.repository.MapRepository mapRepository = null;
    private final com.example.torang_core.repository.FindRepository findRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.cardinfo.RestaurantInfoCardUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.cardinfo.RestaurantInfoCardUiState> uiState = null;
    
    /**
     * 맛집 클릭 이벤트
     */
    private final androidx.lifecycle.MutableLiveData<com.example.torang_core.util.Event<com.example.torang_core.data.model.Restaurant>> _clickCardInfo = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.torang_core.util.Event<com.example.torang_core.data.model.Restaurant>> clickCardInfo = null;
    
    @javax.inject.Inject()
    public RestaurantInfoCardViewModel(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.MapRepository mapRepository, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.FindRepository findRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.cardinfo.RestaurantInfoCardUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.torang_core.util.Event<com.example.torang_core.data.model.Restaurant>> getClickCardInfo() {
        return null;
    }
    
    /**
     * 카드에 있는 맛집 클릭
     */
    public final void clickRestaurant(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.model.Restaurant restaurantData) {
    }
    
    /**
     * 카드 스크롤하서 이동 시 알림
     */
    public final void setCurrentPosition(int position) {
    }
}