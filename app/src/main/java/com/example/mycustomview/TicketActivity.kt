package com.example.mycustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.mycustomview.custom.SeatsView

class TicketActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        hideToolbar()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)
        initView()
    }

    private fun hideToolbar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
    }

    private fun initView() {
        val seatView = findViewById<SeatsView>(R.id.seats_view)
        val button = findViewById<AppCompatButton>(R.id.finish_button)

        button.setOnClickListener {
            seatView.getSeat()?.let {
                Toast.makeText(this, "Kursi Anda nomor ${it.name}.", Toast.LENGTH_SHORT).show()
            } ?: kotlin.run {
                Toast.makeText(this, "Silahkan pilih kursi terlebih dahulu.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}