package com.tugas.arcourse1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val score=intent.getStringExtra(setData.score)
        val totalQuestion=intent.getStringExtra("Total Size")

        selamat.text="Selamat kamu mendapatkan koin ${score}*10"
        Score.text="${score}/${totalQuestion}"
        btn_selesai.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}