package com.agistudio97.whattoeat

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.agistudio97.whattoeat.ConstData.CHINESE
import com.agistudio97.whattoeat.ConstData.FASTFOOD
import com.agistudio97.whattoeat.ConstData.JAPANESE
import com.agistudio97.whattoeat.ConstData.KOREAN
import com.agistudio97.whattoeat.ConstData.OTHER
import com.agistudio97.whattoeat.ConstData.WESTERN
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_food_dialog.view.*
import kotlinx.android.synthetic.main.select_ingredient_dialog.view.*
import java.io.*
import java.lang.Exception
import java.util.*
import java.util.jar.Manifest
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var file: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
        if(permissionCheck != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)

        val sdcardFolder = Environment.getExternalStorageDirectory()
        val sdcardPath = sdcardFolder.absolutePath
        val filename = sdcardPath + File.separator + "PersonalFoods"
        file = File(filename)

        try {
            ObjectInputStream(FileInputStream(file)).run {
                foodlist = readObject() as ArrayList<Food>
                for(food in foodlist) {
                    here@for(ingredient in food.getIngredients()) {
                        for(coingredient in ingredientlist)
                            if(ingredient == coingredient)
                                continue@here
                        ingredientlist.add(ingredient)
                    }
                }
                close()
            }
            Toast.makeText(this, "불러오기 성공", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            initialization()
            Toast.makeText(this, "불러오기 실패", Toast.LENGTH_SHORT).show()
        }

        mainAdapter = FoodMainAdapter().apply {
            for(food in foodlist)
                if(food.isSelected)
                    addFood(food)
        }

        recyclerView.run {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    private fun initialization() {
        FoodData().run {
            for(food in foodarray) {
                foodlist.add(food)
                here@for(ingredient in food.getIngredients()) {
                    for(coingredient in ingredientlist)
                        if(ingredient == coingredient)
                            continue@here
                    ingredientlist.add(ingredient)
                }
            }
        }
    }

    fun onRandomButtonClicked(v: View) {
        AlertDialog.Builder(this).run {
            setTitle("랜덤 추천 결과")
            setMessage(randomPickFrom(mainAdapter.getFoods()).name)
            setPositiveButton("확인") { _, _ -> }
            create()
            show()
        }
    }
    private fun randomPickFrom(list: ArrayList<Food>): Food {
        return list[Random().nextInt(list.size)]
    }

    fun onAddButtonClicked(v: View) {
        AlertDialog.Builder(this).run {
            setTitle("음식 추가")
            val layout = AddFoodDialog(this@MainActivity).apply {
                addSpinner.run {
                    adapter = ArrayAdapter(this@MainActivity, R.layout.support_simple_spinner_dropdown_item, types)
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
                    "한식" -> {type = KOREAN}
                    "중식" -> {type = CHINESE}
                    "일식" -> {type = JAPANESE}
                    "양식" -> {type = WESTERN}
                    "그 외" -> {type = OTHER}
                    "패스트푸드" -> {type = FASTFOOD}
                }

                if(name != "" && selectedIngredients.size>0 && type>0) {
                    val newfood = Food(name, type).apply {
                        setIngredients(selectedIngredients)
                    }
                    foodlist.add(newfood)
                    mainAdapter.run {
                        addFood(newfood)
                        notifyDataSetChanged()
                    }
                        Toast.makeText(this@MainActivity, "음식이 추가되었습니다.", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@MainActivity, "음식 이름, 재료, 종류가 모두 입력되지 않았습니다.", Toast.LENGTH_LONG).show()
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
            val layout = SelectIngredientDialog(this@MainActivity).apply {
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

    fun onEditButtonClicked(v: View) {
        startActivityForResult(Intent(this, EditActivity::class.java), 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1)
            if(resultCode == 1) {
                recyclerView.run {
                    adapter = mainAdapter.apply {
                        clearFoods()
                        for(food in foodlist)
                            if(food.isSelected)
                                addFood(food)
                    }
                }
            }
    }

    private fun save() {
        try {
            ObjectOutputStream(FileOutputStream(file)).run {
                writeObject(foodlist)
                flush()
                close()
            }
            Toast.makeText(this, "저장 성공", Toast.LENGTH_SHORT).show()
        } catch(e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "저장 실패", Toast.LENGTH_SHORT).show()
        }
    }
    fun onSaveButtonClicked(v: View) {
        save()
    }

    override fun onDestroy() {
        save()
        super.onDestroy()
    }

    companion object {
        lateinit var mainAdapter: FoodMainAdapter
        lateinit var editAdapter: FoodEditAdapter

        var foodlist = arrayListOf<Food>()
        val ingredientlist = arrayListOf<String>()
        val selectedIngredients = arrayListOf<String>()

        val types = arrayOf("한식", "중식", "일식", "양식", "그 외", "패스트푸드")
        var selectedType = ""
    }
}
