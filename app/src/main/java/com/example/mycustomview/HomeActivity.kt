package com.example.mycustomview

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.mycustomview.custom.MyButton
import com.example.mycustomview.custom.MyEditText

class HomeActivity : AppCompatActivity() {

    private lateinit var editText: MyEditText
    private lateinit var button: MyButton
    private lateinit var clickButton: AppCompatButton
    private lateinit var btnGoToCustomView: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
    }

    private fun initView() {
        button = findViewById(R.id.my_button)
        editText = findViewById(R.id.my_edit_text)
        clickButton = findViewById(R.id.click_btn_apps)
        btnGoToCustomView = findViewById(R.id.btn_go_to_custom_view)
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

        button showToast editText.text.toString()
        clickButton goTo TicketActivity::class.java
        btnGoToCustomView goTo CustomActivity::class.java
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

    private fun startActivity(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }

    private infix fun View.goTo(cls: Class<*>) {
        setOnClickListener { startActivity(cls) }
    }

    private infix fun View.showToast(text: String) {
        setOnClickListener { Toast.makeText(this@HomeActivity, text, Toast.LENGTH_SHORT).show() }
    }
}