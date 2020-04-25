package com.agistudio97.whattoeat

import android.content.Context
import android.widget.Button
import android.widget.LinearLayout

class TypeAdapter(private val context: Context) {

    private val types = arrayOf("한식", "중식", "일식", "양식", "그 외", "패스트푸드")
    private val checkedIndex = arrayOf(true, true, true, true, true, true)
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
                for(index in types.indices) {
                    checkedIndex[index] = isWholeChecked
                    layout.findViewById<Button>(index).setBackgroundColor(if(checkedIndex[index]) {
                        0xFF03DAC5.toInt()
                    } else {
                        0xFFFFFFFF.toInt()
                    })
                }
            }
        })
        for(index in types.indices)
            layout.addView(Button(context).apply {
                id = index
                text = types[index]
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

    fun isChecked(index: Int): Boolean {
        return checkedIndex[index]
    }
}