package com.pwneill.questiontime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val q1 = QuizModel(R.string.q1, true)
    val q2 = QuizModel(R.string.q2, true)
    val q3 = QuizModel(R.string.q3, true)
    val q4 = QuizModel(R.string.q4, true)
    val q5 = QuizModel(R.string.q5, true)
    val q6 = QuizModel(R.string.q6, true)
    val q7 = QuizModel(R.string.q7, true)
    val q8 = QuizModel(R.string.q8, true)
    val q9 = QuizModel(R.string.q9, true)
    val q10 = QuizModel(R.string.q10, true)

    private val questionBank: Array<QuizModel> = arrayOf(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.txtQuestion);
        textView?.text = "${getString(questionBank.get(0).question)} ";


        fun onClick(v: View?) {

            when (v?.id) {
                R.id.trueBtn -> {
                    Toast.makeText(this, "trueBtn was tapped", Toast.LENGTH_SHORT).show()
                }
                R.id.falseBtn -> {
                    Toast.makeText(this, "falseBtn was tapped", Toast.LENGTH_SHORT).show()

                }
            }
        }

        val trueBtn: Button = findViewById(R.id.trueBtn);
        trueBtn.setOnClickListener{ v: View? -> onClick(v) }

        val falseBtn: Button = findViewById(R.id.falseBtn);
        falseBtn.setOnClickListener{ v: View? -> onClick(v) }

        }

    }
