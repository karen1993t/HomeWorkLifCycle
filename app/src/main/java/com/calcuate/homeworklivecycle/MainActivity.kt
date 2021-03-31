package com.calcuate.homeworklivecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var textCount:TextView
    lateinit var btnCount:Button
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textCount = findViewById(R.id.tv_result)
        btnCount = findViewById(R.id.btn_count)

        if (savedInstanceState != null){
            val isVisible:Boolean = savedInstanceState.getBoolean("reply_visible")
            if (isVisible){
                textCount.text = savedInstanceState.getString("reply_text")
            }
        }
        btnCount.setOnClickListener {

            if (savedInstanceState != null){
               count = textCount.text.toString().toInt()
            }
            count++
            textCount.text = count.toString()
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (textCount.visibility == View.VISIBLE){
            outState.putBoolean("reply_visible",true)
            outState.putString("reply_text", textCount.text.toString())
        }
    }
}