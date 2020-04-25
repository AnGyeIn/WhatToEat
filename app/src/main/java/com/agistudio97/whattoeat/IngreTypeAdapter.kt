package com.agistudio97.whattoeat

import android.content.Context
import android.widget.Button
import android.widget.LinearLayout

class IngreTypeAdapter(private val context: Context) {

    private val ingreTypes = arrayListOf<String>()
    private val checkedIndex = arrayListOf<Boolean>()
    private var isWholeChecked = true

    fun setAdapterTo(layout: LinearLayout) {
        layout.addView(Button(context).apply {
            text = "모두"
            setBackgroundColor(if(isWholeChecked) {
                0xFF03DAC5.toInt()
            } else {
                0xFFFFFFFF.toInt()
            })
            setOnClickListener {
                isWholeChecked = !isWholeChecked
                setBackgroundColor(if(isWholeChecked) {
                    0xFF03DAC5.toInt()
                } else {
                    0xFFFFFFFF.toInt()
                })
                for(index in 0 until ingreTypes.size) {
                    checkedIndex[index] = isWholeChecked
                    layout.findViewById<Button>(index*10).setBackgroundColor(if(checkedIndex[index]) {
                        0xFF03DAC5.toInt()
                    } else {
                        0xFFFFFFFF.toInt()
                    })
                }
            }
        })
        for(index in 0 until ingreTypes.size)
            layout.addView(Button(context).apply {
                id = index*10
                text = ingreTypes[index]
                setBackgroundColor(if(checkedIndex[index]) {
                    0xFF03DAC5.toInt()
                } else {
                    0xFFFFFFFF.toInt()
                })
                setOnClickListener {
                    checkedIndex[index] = !checkedIndex[index]
                    setBackgroundColor(if(checkedIndex[index]) {
                        0xFF03DAC5.toInt()
                    } else {
                        0xFFFFFFFF.toInt()
                    })
                }
            })
    }

    fun addIngreType(ingreType: String) {
        ingreTypes.add(ingreType)
        checkedIndex.add(true)
    }

    fun getCount(): Int {
        return ingreTypes.size
    }

    fun isChecked(index: Int): Boolean {
        return checkedIndex[index]
    }

    fun getIngreType(index: Int): String {
        return ingreTypes[index]
    }
}