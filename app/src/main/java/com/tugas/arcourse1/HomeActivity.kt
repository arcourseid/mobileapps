package com.tugas.arcourse1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.tugas.arcourse1.avatar.AvatarActivity
import com.tugas.arcourse1.databinding.ActivityHomeBinding
import com.tugas.arcourse1.login.LoginActivity
import com.tugas.arcourse1.modul.ModulActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var firebaseAuth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profil")
        val user = firebaseAuth.currentUser
        val userreference = databaseReference?.child(user?.uid!!)

        userreference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tvNama.text = "Hai, " + snapshot.child("Nama Lengkap").value.toString().trim()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

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