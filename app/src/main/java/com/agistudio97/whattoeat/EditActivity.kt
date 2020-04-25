package com.agistudio97.whattoeat

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.agistudio97.whattoeat.MainActivity.Companion.editAdapter
import com.agistudio97.whattoeat.MainActivity.Companion.foodlist
import com.agistudio97.whattoeat.MainActivity.Companion.ingredientlist
import com.agistudio97.whattoeat.MainActivity.Companion.selectedIngredients
import com.agistudio97.whattoeat.MainActivity.Companion.selectedType
import com.agistudio97.whattoeat.MainActivity.Companion.types
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.add_food_dialog.view.*
import kotlinx.android.synthetic.main.select_ingredient_dialog.view.*

class EditActivity: AppCompatActivity() {

    private var isSlotForType = true

    private val typeAdapter = TypeAdapter(this)
    private val ingreTypeAdapter = IngreTypeAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        setSlot()
        typeAdapter.setAdapterTo(typeLinearLayout)
        for(ingreType in ingredientlist)
            ingreTypeAdapter.addIngreType(ingreType)
        ingreTypeAdapter.setAdapterTo(ingreTypeLinearLayout)

        editAdapter = FoodEditAdapter().apply {
            for(food in foodlist)
                addFood(food)
        }

        editRecyclerView.run {
            adapter = editAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }

        wholeSwitch.run {
            isChecked = true
            setOnCheckedChangeListener { _, isChecked ->
                editRecyclerView.run {
                    val adapter = adapter as FoodEditAdapter
                    adapter.run {
                        for(food in getFoods())
                            food.isSelected = isChecked

                        notifyDataSetChanged()
                    }
                }
            }
        }

    }

    private fun setSlot() {
        if(isSlotForType) {
            typeScrollView.visibility = View.VISIBLE
            ingreTypeScrollView.visibility = View.INVISIBLE
            slotButton.text = "재료별 보기"
        } else {
            typeScrollView.visibility = View.INVISIBLE
            ingreTypeScrollView.visibility = View.VISIBLE
            slotButton.text = "종류별 보기"
        }
    }

    fun onSlotButtonClicked(v: View) {
        isSlotForType = !isSlotForType
        setSlot()
    }

    fun onEditFinishButtonClicked(v: View) {
        setResult(1)
        finish()
    }

    fun onAddButtonClicked(v: View) {
        AlertDialog.Builder(this).run {
            setTitle("음식 추가")
            val layout = AddFoodDialog(this@EditActivity).apply {
                addSpinner.run {
                    adapter = ArrayAdapter(this@EditActivity, R.layout.support_simple_spinner_dropdown_item, types)
                    onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {}
                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                            selectedType = types[position]
                        }

                    }
                }
            }
            setView(layout)
            setPositiveButton("추가") { _, _ ->
                val name = layout.addNameEditText.text.toString()

                val newIngredients = layout.addIngredientEditText.text.toString()
                if(newIngredients != "") {
                    var ingredient = ""
                    for(x in "$newIngredients ") {
                        if(x==',' || x==' ') {
                            if(ingredient != "") {
                                ingredientlist.add(ingredient)
                                selectedIngredients.add(ingredient)
                                ingredient = ""
                            }
                            continue
                        }
                        ingredient += x
                    }
                }

                var type = 0
                when(selectedType) {
                    "한식" -> {type = ConstData.KOREAN
                    }
                    "중식" -> {type = ConstData.CHINESE
                    }
                    "일식" -> {type = ConstData.JAPANESE
                    }
                    "양식" -> {type = ConstData.WESTERN
                    }
                    "그 외" -> {type = ConstData.OTHER
                    }
                    "패스트푸드" -> {type = ConstData.FASTFOOD
                    }
                }

                if(name != "" && selectedIngredients.size>0 && type>0) {
                    val newfood = Food(name, type).apply {
                        setIngredients(selectedIngredients)
                    }
                    foodlist.add(newfood)
                    editAdapter.run {
                        addFood(newfood)
                        notifyDataSetChanged()
                    }
                    Toast.makeText(this@EditActivity, "음식이 추가되었습니다.", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@EditActivity, "음식 이름, 재료, 종류가 모두 입력되지 않았습니다.", Toast.LENGTH_LONG).show()
                }

                selectedIngredients.clear()

            }
            create()
            show()
        }
    }

    fun onAddIngredientButtonClicked(v: View) {
        AlertDialog.Builder(this).run {
            setTitle("재료 선택")
            val layout = SelectIngredientDialog(this@EditActivity).apply {
                ingredientRecyclerView.run {
                    adapter = IngredientAdapter().apply {
                        for(ingredient in ingredientlist)
                            addIngredient(ingredient)
                        checkSelectedIngredients(selectedIngredients)
                    }
                    layoutManager = LinearLayoutManager(applicationContext)
                }
            }
            setView(layout)
            setPositiveButton("선택") { _, _ ->
                (layout.ingredientRecyclerView.adapter as IngredientAdapter).copySelectedIngredients(selectedIngredients)
            }
            create()
            show()
        }
    }

    fun onApplyButtonClicked(v: View) {
        editRecyclerView.run {
            adapter = editAdapter.apply {
                clearFood()
                if(isSlotForType) {
                    val selectedTypes = arrayListOf<Int>()
                    for(i in 0..5)
                        typeAdapter.run {
                            if (isChecked(i))
                                selectedTypes.add(i + 1)
                        }

                    for(food in foodlist)
                        if(selectedTypes.contains(food.foodcode))
                            addFood(food)
                } else {
                    val selectedIngreTypes = arrayListOf<String>()
                    ingreTypeAdapter.run {
                        for(i in 0 until getCount())
                            if(isChecked(i))
                                selectedIngreTypes.add(getIngreType(i))
                    }

                    here@for(food in foodlist) {
                        for(ingredient in food.getIngredients()) {
                            if(!selectedIngreTypes.contains(ingredient))
                                continue@here
                        }
                        addFood(food)
                    }
                }
                notifyDataSetChanged()
            }
        }
    }
}