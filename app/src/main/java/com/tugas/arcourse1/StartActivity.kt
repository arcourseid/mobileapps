package com.tugas.arcourse1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tugas.arcourse1.databinding.ActivityStartBinding
import com.tugas.arcourse1.login.LoginActivity
import com.tugas.arcourse1.login.RegisterActivity

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        binding.btnSignUp.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

            finish()
        }
        binding.btnLogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}