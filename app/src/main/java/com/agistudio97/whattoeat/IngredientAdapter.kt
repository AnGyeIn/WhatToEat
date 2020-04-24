package com.agistudio97.whattoeat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.ingredient_item.view.*

class IngredientAdapter: RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>() {

    private val ingredients = arrayListOf<String>()
    private val checkedIndex = arrayListOf<Boolean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        return IngredientViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ingredient_item, parent, false).apply {
            ingredientSwtich
        })
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.containerView.run {
            ingredientSwtich.run {
                text = ingredients[position]
                isChecked = checkedIndex[position]

                setOnCheckedChangeListener { _, isChecked ->
                    checkedIndex[position] = isChecked
                }
            }
        }
    }

    fun addIngredient(ingredient: String) {
        ingredients.add(ingredient)
        checkedIndex.add(false)
    }

    fun checkSelectedIngredients(selectedList: ArrayList<String>) {
        for(x in selectedList)
            for(index in 0 until ingredients.size)
                if(x == ingredients[index])
                    checkedIndex[index] = true
    }

    fun copySelectedIngredients(listToCopy: ArrayList<String>) {
        listToCopy.clear()
        for(index in 0 until ingredients.size)
            if(checkedIndex[index])
                listToCopy.add(ingredients[index])
    }

    class IngredientViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer
}