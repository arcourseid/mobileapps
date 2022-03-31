package com.tugas.arcourse1.modul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tugas.arcourse1.HomeActivity
import com.tugas.arcourse1.R
import com.tugas.arcourse1.soal.QuestionLimasActivity
import kotlinx.android.synthetic.main.activity_modul_reward.*

class ModulRewardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modul_reward)

        btnMulaiQuiz.setOnClickListener {
            startActivity(Intent(this, QuestionLimasActivity::class.java))
            finish()
        }

        imgBack.setOnClickListener {
            startActivity(Intent(this, ModulActivity::class.java))
        }

        imgHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}