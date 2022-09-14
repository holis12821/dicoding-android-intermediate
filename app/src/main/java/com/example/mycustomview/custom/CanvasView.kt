package com.example.mycustomview.custom

import android.content.Context
import android.graphics.*
import android.os.Build
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.example.mycustomview.R

class CanvasView(context: Context) : View(context) {

    fun createCanvasWithBitMap(mCanvas: Canvas?, mBitmap: Bitmap) {
        val mPaint = Paint()

        //draw rect
        mPaint.color = ResourcesCompat.getColor(resources, R.color.pink_500, null)
        val mRect = Rect()
        mRect.set(
            mBitmap.width / 2 - 100,
            mBitmap.height / 2 - 100,
            mBitmap.width / 2 + 100,
            mBitmap.height / 2 + 100
        )

        mCanvas?.save()

        //Clipping and merge object in canvas
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            mCanvas?.clipRect(
                mBitmap.width / 2 - 100F,
                mBitmap.height / 2 - 100F,
                mBitmap.width / 2 + 100F,
                mBitmap.height / 2 + 100F,
                Region.Op.DIFFERENCE
            )
        } else {
            mCanvas?.clipOutRect(
                mBitmap.width / 2 - 100,
                mBitmap.height / 2 - 100,
                mBitmap.width / 2 + 100,
                mBitmap.height / 2 + 100
            )
        }

        //draw circle
        mPaint.color = ResourcesCompat.getColor(resources, R.color.blue_500, null)
        mCanvas?.drawCircle(
            (mBitmap.width / 2).toFloat(),
            (mBitmap.height / 2).toFloat(),
            200f,
            mPaint
        )

        mCanvas?.restore()

        //create text style on paint
        val mPaintText = Paint(Paint.FAKE_BOLD_TEXT_FLAG)
        mPaintText.textSize = 20F
        mPaintText.color = ResourcesCompat.getColor(resources, R.color.white, null)

        //set position of the text
        val mText = "Selamat Datang!"
        val mBounds = Rect()
        mPaintText.getTextBounds(mText, 0, mText.length, mBounds)

        //Set position on the text base on (x,y) axis
        val x = mBitmap.width / 2 - mBounds.centerX()
        val y = mBitmap.height / 2 - mBounds.centerY()

        mCanvas?.drawText(mText, x.toFloat(), y.toFloat(), mPaintText)
    }
}