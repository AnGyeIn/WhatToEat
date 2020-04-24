package com.agistudio97.whattoeat

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.add_food_dialog.view.*

class AddFoodDialog(context: Context): LinearLayout(context) {
    init {
        LayoutInflater.from(context).run {
            inflate(R.layout.add_food_dialog, this@AddFoodDialog, true)
            addNameEditText
            addIngredientEditText
            addSpinner
        }
    }
}