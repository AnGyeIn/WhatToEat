package com.agistudio97.whattoeat

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.select_ingredient_dialog.view.*

class SelectIngredientDialog(context: Context): LinearLayout(context) {
    init {
        LayoutInflater.from(context).run {
            inflate(R.layout.select_ingredient_dialog, this@SelectIngredientDialog, true)
            ingredientRecyclerView
        }
    }
}