package com.tugas.arcourse1.soal

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.tugas.arcourse1.R
import com.tugas.arcourse1.data.QuestionData
import com.tugas.arcourse1.data.setDataLingkaran
import com.tugas.arcourse1.modul.ResultActivity
import kotlinx.android.synthetic.main.activity_question.*
import java.util.concurrent.TimeUnit

class QuestionLingkaranActivity : AppCompatActivity() {

    companion object {
        const val TAG = "QuestionActivity"
    }

    private var score: Int = 0
    private var currentPosition: Int = 1
    private var questionList: ArrayList<QuestionData>? = null
    private var selectedOption: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        questionList = setDataLingkaran.getQuestion()

        setQuestion()

        opt_1.setOnClickListener {
            selectedOptionStyle(opt_1, 1)
        }
        opt_2.setOnClickListener {
            selectedOptionStyle(opt_2, 2)
        }
        opt_3.setOnClickListener {
            selectedOptionStyle(opt_3, 3)
        }
        opt_4.setOnClickListener {
            selectedOptionStyle(opt_4, 4)
        }

        submit.setOnClickListener {
            if (selectedOption != 0) {
                val question = questionList!![currentPosition - 1]
                if (selectedOption != question.correct_ans) {
                    score = score;
                } else {
                    score++;
                }
                setColor(question.correct_ans, R.drawable.bg_correct_question_option)
                if (currentPosition == questionList!!.size)
                    submit.text = "FINISH"
                else
                    submit.text = "NEXT"
            } else {
                currentPosition++
                when {
                    currentPosition <= questionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        var intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(setDataLingkaran.score, score.toString())
                        intent.putExtra("Total Size", questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption = 0
        }
    }

    fun setColor(opt: Int, color: Int) {
        when (opt) {
            1 -> {
                opt_1.background = ContextCompat.getDrawable(this, color)
            }
            2 -> {
                opt_2.background = ContextCompat.getDrawable(this, color)
            }
            3 -> {
                opt_3.background = ContextCompat.getDrawable(this, color)
            }
            4 -> {
                opt_4.background = ContextCompat.getDrawable(this, color)
            }
        }

    }

    fun setQuestion() {
        val question = questionList!![currentPosition - 1]
        countDownTimer.start()
        setOptionStyle()

        progress_bar.progress = currentPosition
        progress_bar.max = questionList!!.size
        progress_text.text = "${currentPosition}" + "/" + "${progress_bar.max}"
        question_text.text = question.question
        opt_1.text = question.option_one
        opt_2.text = question.option_two
        opt_3.text = question.option_three
        opt_4.text = question.option_four
    }

    private var countDownTimer = object : CountDownTimer(1000 * 120, 1000) {
        override fun onTick(mil: Long) {
            Log.d(TAG, "onTick: ${mil / 1000f}")
            //update text
            tvDetik?.text = getString(
                R.string.formatted_time,
                TimeUnit.MILLISECONDS.toSeconds(mil) % 60
            )
        }

        override fun onFinish() {
            Log.d(TAG, "onFInish: called")
        }

    }

    fun setOptionStyle() {
        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(0, opt_1)
        optionList.add(1, opt_2)
        optionList.add(2, opt_3)
        optionList.add(3, opt_4)

        for (op in optionList) {
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.bg_white_oval)
            op.typeface = Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view: TextView, opt: Int) {
        setOptionStyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.bg_white_oval2)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}