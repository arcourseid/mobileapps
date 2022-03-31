package com.tugas.arcourse1.modul

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.tugas.arcourse1.HomeActivity
import com.tugas.arcourse1.R
import com.tugas.arcourse1.data.setDataLimas
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val score=intent.getStringExtra(setDataLimas.score)
        val totalQuestion=intent.getStringExtra("Total Size")

        tvSelamat.text= "Selamat kamu mendapatkan ${score!!.toInt()*10} koin"
        Score.text="${score}/${totalQuestion}"

        btnSelesai.setOnClickListener {
            val view = View.inflate(this@ResultActivity, R.layout.custom_dialog, null)

            val builder = AlertDialog.Builder(this@ResultActivity)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setCanceledOnTouchOutside(true)

            view.btnForm.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/form_arcourse")))
            }

            view.imgCancel.setOnClickListener {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }
    }
}