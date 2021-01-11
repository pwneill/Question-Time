package com.pwneill.questiontime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun onClick(v: View?) {

            when (v?.id) {
                R.id.trueBtn -> {
                    Log.i("btn", "tueBtn was tapped")
                }
                R.id.falseBtn -> {
                    Log.i("btn", "falseBtn was tapped")
                }
            }
        }


        val trueBtn: Button = findViewById(R.id.trueBtn);
        trueBtn.setOnClickListener{ v: View? -> onClick(v) }

        val falseBtn: Button = findViewById(R.id.falseBtn);
        falseBtn.setOnClickListener{ v: View? -> onClick(v) }

//            trueBtn.set

//            trueBtn.setOnClickListener(onClick(View v))
//
//        trueBtn.setOnClickListener() {
//
//            Log.i("btn", "true was clicked")
//
//        }
//
//        val falseBtn: Button = findViewById(R.id.falseBtn);
//            falseBtn.setOnClickListener()
//
//        falseBtn.setOnClickListener() {
//
//            Log.i("btn", "false was clicked")

        }

    }
