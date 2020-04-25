package com.agistudio97.whattoeat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.food_item_edit.view.*

class FoodEditAdapter(private val context: Context): BaseAdapter() {

    private val foods = arrayListOf<Food>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return FoodItemEdit(context).apply {
            foodSwitch.run {
                text = foods[position].name
                isChecked = foods[position].isSelected
                setOnCheckedChangeListener { _, isChecked ->
                    foods[position].isSelected = isChecked
                }
            }
        }
    }

    override fun getItem(position: Int): Any {
        return foods[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return foods.size
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

    class FoodItemEdit(context: Context): LinearLayout(context) {
        init {
            LayoutInflater.from(context).run {
                inflate(R.layout.food_item_edit, this@FoodItemEdit, true)
                foodSwitch
            }
        }
    }
}