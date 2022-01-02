package com.tugas.arcourse1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.tugas.arcourse1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.layoutBangunRuang.setOnClickListener {
            startActivity(Intent(this, ModulActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }

        binding.account.setOnClickListener {
            startActivity(Intent(this, AvatarActivity::class.java))
        }
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}