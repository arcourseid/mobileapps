package com.tugas.arcourse1.modul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tugas.arcourse1.R
import kotlinx.android.synthetic.main.activity_modul_reward.*

class ModulRewardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modul_reward)

        button.setOnClickListener {
            startActivity(Intent(this, QuestionActivity::class.java))
        }
    }
}