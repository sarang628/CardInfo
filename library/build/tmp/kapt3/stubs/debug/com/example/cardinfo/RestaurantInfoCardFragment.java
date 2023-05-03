package com.example.cardinfo;

import java.lang.System;

/**
 * 맛집정보카드 화면입니다.
 * [FragmentViewPagerBinding]
 * [CardInfoVp2Adt]
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/cardinfo/RestaurantInfoCardFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/example/cardinfo/CardInfoVp2Adt;", "moveCardPosition", "", "viewPater", "Landroidx/viewpager2/widget/ViewPager2;", "position", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setPagerScrollListener", "vp", "showCard", "view", "", "subScribeUiState", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/cardinfo/RestaurantInfoCardUiState;", "binding", "Lcom/example/cardinfo/databinding/FragmentRestaurantInfoCardBinding;", "library_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class RestaurantInfoCardFragment extends androidx.fragment.app.Fragment {
    
    /**
     * 카드정보 뷰페이저 아답터
     */
    private com.example.cardinfo.CardInfoVp2Adt adapter;
    
    public RestaurantInfoCardFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public final void subScribeUiState(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.StateFlow<com.example.cardinfo.RestaurantInfoCardUiState> uiState, @org.jetbrains.annotations.NotNull()
    com.example.cardinfo.databinding.FragmentRestaurantInfoCardBinding binding) {
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