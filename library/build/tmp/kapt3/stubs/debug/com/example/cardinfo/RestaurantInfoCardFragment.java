package com.example.cardinfo;

import java.lang.System;

/**
 * 맛집정보카드 화면입니다.
 * [FragmentViewPagerBinding]
 * [CardInfoVp2Adt]
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0014H\u0002J\u0018\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010!\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\'"}, d2 = {"Lcom/example/cardinfo/RestaurantInfoCardFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/example/cardinfo/CardInfoVp2Adt;", "restaurantDetailNavigation", "Lcom/sryang/torang_core/navigation/RestaurantDetailNavigation;", "getRestaurantDetailNavigation", "()Lcom/sryang/torang_core/navigation/RestaurantDetailNavigation;", "setRestaurantDetailNavigation", "(Lcom/sryang/torang_core/navigation/RestaurantDetailNavigation;)V", "viewModel", "Lcom/example/cardinfo/RestaurantInfoCardViewModel;", "getViewModel", "()Lcom/example/cardinfo/RestaurantInfoCardViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "moveCardPosition", "", "viewPater", "Landroidx/viewpager2/widget/ViewPager2;", "position", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setPagerScrollListener", "vp", "showCard", "view", "", "subScribeUi", "binding", "Lcom/example/cardinfo/databinding/FragmentRestaurantInfoCardBinding;", "library_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class RestaurantInfoCardFragment extends androidx.fragment.app.Fragment {
    
    /**
     * 맛집정보카드 뷰모델
     */
    private final kotlin.Lazy viewModel$delegate = null;
    
    /**
     * 카드정보 뷰페이저 아답터
     */
    private com.example.cardinfo.CardInfoVp2Adt adapter;
    
    /**
     * 맛집 상세화며 이동 네비게이션
     */
    @javax.inject.Inject()
    public com.sryang.torang_core.navigation.RestaurantDetailNavigation restaurantDetailNavigation;
    
    public RestaurantInfoCardFragment() {
        super();
    }
    
    /**
     * 맛집정보카드 뷰모델
     */
    private final com.example.cardinfo.RestaurantInfoCardViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sryang.torang_core.navigation.RestaurantDetailNavigation getRestaurantDetailNavigation() {
        return null;
    }
    
    public final void setRestaurantDetailNavigation(@org.jetbrains.annotations.NotNull()
    com.sryang.torang_core.navigation.RestaurantDetailNavigation p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    /**
     * UI 구독
     */
    private final void subScribeUi(com.example.cardinfo.databinding.FragmentRestaurantInfoCardBinding binding) {
    }
    
    /**
     * 페이지 스크롤 시 이벤트 전달합니다.
     */
    private final void setPagerScrollListener(androidx.viewpager2.widget.ViewPager2 vp) {
    }
    
    /**
     * 카드 애니메이션으로 보여줍니다.
     */
    private final void showCard(android.view.View view, boolean showCard) {
    }
    
    /**
     * 카드 위치를 이동시킵니다.
     */
    private final void moveCardPosition(androidx.viewpager2.widget.ViewPager2 viewPater, int position) {
    }
}