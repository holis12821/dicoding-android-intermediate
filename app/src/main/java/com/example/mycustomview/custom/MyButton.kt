package com.example.mycustomview.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.mycustomview.R

class MyButton : AppCompatButton {

    //attribute
    private var mEnableBackground: Drawable? = null
    private var mDisabledBackground: Drawable? = null
    private var mTxtSize = 0.0f
    private var mTxtColor = 0
    private var mGravity = 0

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        mEnableBackground = ContextCompat.getDrawable(context, R.drawable.bg_button)
        mDisabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button_disable)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = if (isEnabled) mEnableBackground else mDisabledBackground
        text = if (isEnabled) context.getString(R.string.submit_btn) else context.getString(R.string.fill_first)

        setTextColor(mTxtColor)
        textSize = mTxtSize
        gravity = mGravity
        isAllCaps = false
    }

    fun setAttribute(textColor: Int, textSize: Float, gravity: Int) {
        mTxtColor = textColor
        mTxtSize = textSize
        mGravity = gravity
    }

}