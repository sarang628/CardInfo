package com.example.cardinfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cardinfo.databinding.FragmentTorangCardVpItemBinding

/**
 * [CardInfoViewHolder]
 */
class CardInfoVp2Adt() :
    RecyclerView.Adapter<CardInfoViewHolder>() {

    private var restaurants: List<Restaurant> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardInfoViewHolder {
        return CardInfoViewHolder(
            FragmentTorangCardVpItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CardInfoViewHolder, position: Int) {
        holder.setData(restaurants[position])
    }

    override fun getItemCount(): Int {
        return restaurants.size;
    }

    fun setRestaurants(
        restaurants: List<Restaurant>
    ) {
        this.restaurants = restaurants
        notifyDataSetChanged()
    }
}

class CardInfoViewHolder(
    val binding: FragmentTorangCardVpItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setData(restaurant: Restaurant) {
        binding.tvRestaurantName.text = restaurant.restaurantName
    }
}