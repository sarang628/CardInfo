package com.example.cardinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.cardinfo.databinding.FragmentRestaurantInfoCardBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * 맛집정보카드 화면입니다.
 * [FragmentViewPagerBinding]
 * [CardInfoVp2Adt]
 */
@AndroidEntryPoint
class RestaurantInfoCardFragment : Fragment() {
    /** 카드정보 뷰페이저 아답터 */
    private lateinit var adapter: CardInfoVp2Adt

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        // 페이지 아답터 초기화
        adapter = CardInfoVp2Adt()

        // 바인딩 초기화
        val binding = FragmentRestaurantInfoCardBinding.inflate(layoutInflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
            }

        binding.vp.adapter = adapter

        subScribeUiState(testRestaurantInfoCardUiState(), binding)

        return binding.root
    }

    fun subScribeUiState(uiState: StateFlow<RestaurantInfoCardUiState>, binding: FragmentRestaurantInfoCardBinding){
        viewLifecycleOwner.lifecycleScope.launch {
            uiState.collect {
                adapter.setRestaurants(it.restaurants)
            }
        }
    }


    /**
     * 페이지 스크롤 시 이벤트 전달합니다.
     */
    private fun setPagerScrollListener(vp: ViewPager2) {
        vp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })
    }

    /**
     * 카드 애니메이션으로 보여줍니다.
     */
    private fun showCard(view: View, showCard: Boolean) {
        if (
            (view.visibility == View.VISIBLE && showCard)
            || (view.visibility == View.INVISIBLE && !showCard)
        ) {
            return
        }

        val animation = AnimationUtils.loadAnimation(
            context, if (showCard) R.anim.slide_card_up1 else R.anim.slide_card_down1
        )
        view.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                if (showCard) view.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation) {
                if (!showCard) view.visibility = View.INVISIBLE
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
    }

    /**
     * 카드 위치를 이동시킵니다.
     */
    private fun moveCardPosition(viewPater: ViewPager2, position: Int) {
        if (viewPater.currentItem != position) {
            viewPater.post {
                viewPater.setCurrentItem(position, true)
            }
        }
    }
}