package com.agistudio97.whattoeat

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.food_item_main.view.*
import java.io.Serializable

class FoodMainAdapter: RecyclerView.Adapter<FoodMainAdapter.FoodViewHolder>() {

    private var foods = arrayListOf<Food>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.food_item_main, parent, false))
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.containerView.run {
            foods[position].run {
                foodMainTextView.text = name
            }
        }
    }

    fun addFood(food: Food) {
        foods.add(food)
    }

    fun getFoods(): ArrayList<Food> {
        return foods
    }

    fun clearFoods() {
        foods.clear()
    }

    class FoodViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer
}