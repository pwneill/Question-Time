package com.pwneill.questiontime

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {

    var index = 0

    val q1 = QuizModel(R.string.q1, true)
    val q2 = QuizModel(R.string.q2, false)
    val q3 = QuizModel(R.string.q3, false)
    val q4 = QuizModel(R.string.q4, true)
    val q5 = QuizModel(R.string.q5, true)
    val q6 = QuizModel(R.string.q6, true)
    val q7 = QuizModel(R.string.q7, false)
    val q8 = QuizModel(R.string.q8, false)
    val q9 = QuizModel(R.string.q9, true)
    val q10 = QuizModel(R.string.q10, false)

    private val questionBank: Array<QuizModel> = arrayOf(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.txtQuestion);
        textView?.text = "${getString(questionBank.get(index).question)} ";


        fun onClick(v: View?) {

            when (v?.id) {
                R.id.trueBtn -> {
                    checkGuess(true, questionBank.get(index).answer)
                    changeQuestion()
                }
                R.id.falseBtn -> {
                    checkGuess(false, questionBank.get(index).answer)
                    changeQuestion()
                }
            }
        }

        val trueBtn: Button = findViewById(R.id.trueBtn);
        trueBtn.setOnClickListener{ v: View? -> onClick(v) }

        val falseBtn: Button = findViewById(R.id.falseBtn);
        falseBtn.setOnClickListener{ v: View? -> onClick(v) }

        }

    private fun changeQuestion () {

        questionBank.iterator()

        index += 1

        if (index < questionBank.count()) {


            val textView = findViewById<TextView>(R.id.txtQuestion);
            textView?.text = "${getString(questionBank.get(index).question)} ";

        } else {

            return
        }

    }

     private fun checkGuess ( userGuess: Boolean, answer: Boolean) {
        Log.i("checkGuess", "foo")

        val msg: String?

        if (userGuess === answer) {
            msg = "Correct!"

            } else {
                msg = "Incorrect :("

        }

         Toast.makeText(this,"$msg ",Toast.LENGTH_SHORT).show()

     }

}
