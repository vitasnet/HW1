package ru.geekbrains.lesson_1314_3_1_main.utils

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class CustomImageView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyleAttr:Int=0)
    :AppCompatImageView(context,attr,defStyleAttr){

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}