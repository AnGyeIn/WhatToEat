package com.agistudio97.whattoeat

import java.io.Serializable

class Food(val name: String, val foodcode: Int): Serializable {
    var isSelected = true
    private val ingredients = arrayListOf<String>()
    private var recommendCount = 0
    private var successCount = 0

    fun setIngredients(list: ArrayList<String>) {
        for(ingredient in list)
            ingredients.add(ingredient)
    }

    fun getIngredients(): ArrayList<String> {
        return ingredients
    }

    fun addIngredient(ingredient: String) {
        ingredients.add(ingredient)
    }
}