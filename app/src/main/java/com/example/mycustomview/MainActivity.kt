package com.example.mycustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.core.content.ContextCompat
import com.example.mycustomview.custom.MyButton

class MainActivity : AppCompatActivity() {

    private lateinit var button: MyButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        button = findViewById(R.id.my_button)
        setComponent()
    }

    private fun setComponent() {
        button.setAttribute(
            textColor = ContextCompat.getColor(this, R.color.white),
            textSize = resources.getDimension(R.dimen.text_large),
            gravity = Gravity.CENTER
        )

    }
}