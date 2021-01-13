package com.pwneill.questiontime

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var index: Int = 0

    private val q1 = QuizModel(R.string.q1, true)
    private val q2 = QuizModel(R.string.q2, false)
    private val q3 = QuizModel(R.string.q3, false)
    private val q4 = QuizModel(R.string.q4, true)
    private val q5 = QuizModel(R.string.q5, true)
    private val q6 = QuizModel(R.string.q6, true)
    private val q7 = QuizModel(R.string.q7, false)
    private val q8 = QuizModel(R.string.q8, false)
    private val q9 = QuizModel(R.string.q9, true)
    private val q10 = QuizModel(R.string.q10, false)

    private val questionBank: Array<QuizModel> = arrayOf(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10)
    private var userScore = 0
    private val userProgress: Int = kotlin.math.ceil(100.0 / questionBank.size).toInt()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val questionText = getString(questionBank[index].question)
        val textQuestion = findViewById<TextView>(R.id.txtQuestion)
            textQuestion?.text = questionText

        val statsText = findViewById<TextView>(R.id.quizStats)
             statsText.text = "Your score: $userScore"


        fun onClick(v: View?) {

            when (v?.id) {
                R.id.trueBtn -> {
                    checkGuess(true, questionBank[index].answer)
                    changeQuestion()
                }
                R.id.falseBtn -> {
                    checkGuess(false, questionBank[index].answer)
                    changeQuestion()
                }
            }
        }

        val trueBtn = findViewById<Button>(R.id.trueBtn)
            trueBtn.setOnClickListener{ v: View? -> onClick(v) }

        val falseBtn: Button = findViewById(R.id.falseBtn)
            falseBtn.setOnClickListener{ v: View? -> onClick(v) }

        }

    private fun changeQuestion () {

        index = (index + 1) % 10

        if (index == 0) {

            val quizAlert = AlertDialog.Builder(this)
                quizAlert.setCancelable(false)
                quizAlert.setTitle("Game Over!")
                quizAlert.setMessage("Your score was $userScore")
                quizAlert.setPositiveButton("Finish") { _, _ -> finish()}

            quizAlert.show()
        }

        questionBank.iterator()

        Log.i("newIndex", "$index")
//
        val textQuestion = findViewById<TextView>(R.id.txtQuestion)
        val questionText = getString(questionBank[index].question)
            textQuestion?.text = "$questionText"

        val progressBar = findViewById<ProgressBar>(R.id.quizProgressBar)
            progressBar.incrementProgressBy(userProgress)

    }

     private fun checkGuess ( userGuess: Boolean, answer: Boolean) {
        Log.i("checkGuess", "foo")

        val msg: String?


         if (userGuess == answer) {
             userScore += 1
            msg = getString(R.string.correctToast)

             val statsText = findViewById<TextView>(R.id.quizStats)
             statsText.text = "Your score: $userScore"

            } else {
            msg = "${getString(R.string.incorrectToast)}"

        }

         Toast.makeText(this,"$msg ",Toast.LENGTH_SHORT).show()

     }

}

//private val textStats = findViewById<TextView>(R.id.quizStats)