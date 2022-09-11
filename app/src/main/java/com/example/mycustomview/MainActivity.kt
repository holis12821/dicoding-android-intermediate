package com.example.mycustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.mycustomview.custom.MyButton
import com.example.mycustomview.custom.MyEditText

class MainActivity : AppCompatActivity() {

    private lateinit var editText: MyEditText
    private lateinit var button: MyButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        button = findViewById(R.id.my_button)
        editText = findViewById(R.id.my_edit_text)
        setComponent()
        setMyButtonEnable()
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        button.setOnClickListener { Toast.makeText(this, editText.text, Toast.LENGTH_SHORT).show() }
    }

    private fun setComponent() {
        button.setAttribute(
            textColor = ContextCompat.getColor(this, R.color.white),
            textSize = 12F,
            gravity = Gravity.CENTER
        )
        editText.setAttribute(
            hintText = getString(R.string.hint_edit_text),
            textAlignment = View.TEXT_ALIGNMENT_VIEW_START
        )
    }

    private fun setMyButtonEnable() {
        val result = editText.text
        button.isEnabled = !result.isNullOrEmpty() && result.toString().isNotEmpty()
    }
}