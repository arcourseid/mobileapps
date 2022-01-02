package com.tugas.arcourse1

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.tugas.arcourse1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var progressDialog: ProgressDialog
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Logging In...")
        progressDialog.setCanceledOnTouchOutside(false)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.tvforSignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            validateData()
        }
    }

    private fun checkUser() {
        //if user is already logged in
        //get current user
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }

    private fun validateData() {
        //get data
        email = binding.edtEmail.text.toString().trim()
        password = binding.edtPassword.text.toString().trim()

        //validasi data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            //bila format tidak sesuai
            binding.edtEmail.error = "Invalid email format"
        } else if (TextUtils.isEmpty(password)) {
            //bila password tidak diisi
            binding.edtPassword.error = "Please enter password"
        } else {
            //data tervalidasi
            firebaseLogin()
        }
    }

    private fun firebaseLogin() {
        //show progress
        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //login berhasil
                progressDialog.dismiss()
                //get user info
                Toast.makeText(this, "Selamat datang", Toast.LENGTH_SHORT).show()

                //open home activity
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                //login gagal
                progressDialog.dismiss()
                Toast.makeText(this, "Login failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}