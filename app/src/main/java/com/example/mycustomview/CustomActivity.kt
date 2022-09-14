package com.example.mycustomview

import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mycustomview.custom.CanvasView

class CustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mCanvasView = CanvasView(this)
        setContentView(mCanvasView)
        initView(mCanvasView)
    }

    private fun initView(mCanvasView: CanvasView) {
        val mBitMap = Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888)
        val mCanvas = Canvas(mBitMap)
        mCanvasView.createCanvasWithBitMap(mCanvas = mCanvas, mBitmap = mBitMap)
    }
}