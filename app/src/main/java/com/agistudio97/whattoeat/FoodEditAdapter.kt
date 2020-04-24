package com.agistudio97.whattoeat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.food_item_edit.view.*

class FoodEditAdapter: RecyclerView.Adapter<FoodEditAdapter.FoodEditViewHolder>() {

    private val foods = arrayListOf<Food>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodEditViewHolder {
        return FoodEditViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.food_item_edit, parent, false).apply {
            foodSwitch
        })
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    override fun onBindViewHolder(holder: FoodEditViewHolder, position: Int) {
        holder.containerView.run {
                foodSwitch.run {
                    text = foods[position].name
                    isChecked = foods[position].isSelected
                    setOnCheckedChangeListener { _, isChecked ->
                        foods[position].isSelected = isChecked
                    }
                }
        }
    }

    fun addFood(food: Food) {
        foods.add(food)
    }

    fun getFoods(): ArrayList<Food> {
        return foods
    }

    fun clearFood() {
        foods.clear()
    }

    class FoodEditViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer
}