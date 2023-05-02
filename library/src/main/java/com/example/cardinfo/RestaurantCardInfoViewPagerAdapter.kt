package com.example.cardinfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.cardinfo.databinding.FragmentTorangCardVpItemBinding

/**
 * [CardInfoViewHolder]
 */
class CardInfoVp2Adt(val cardInfoViewModel: RestaurantInfoCardViewModel, val lifecycleOwner: LifecycleOwner) :
    RecyclerView.Adapter<CardInfoViewHolder>() {

//    private var restaurants: List<Restaurant> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardInfoViewHolder {
        return CardInfoViewHolder(
            FragmentTorangCardVpItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ).apply {
//                cardInfoViewModel = this@CardInfoVp2Adt.cardInfoViewModel
//                lifecycleOwner = this@CardInfoVp2Adt.lifecycleOwner
            }
        )
    }

    override fun onBindViewHolder(holder: CardInfoViewHolder, position: Int) {
//        holder.setData(restaurants[position])
    }

    override fun getItemCount(): Int {
//        return restaurants.size
        return 0;
    }

    fun setRestaurants(

    ) {

    }
}

class CardInfoViewHolder(
    val binding: FragmentTorangCardVpItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setData() {
        //binding.restaurant = restaurantData
    }
}