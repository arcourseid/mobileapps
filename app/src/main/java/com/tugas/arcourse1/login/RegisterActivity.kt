package com.tugas.arcourse1.login

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.tugas.arcourse1.HomeActivity
import com.tugas.arcourse1.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var progressDialog: ProgressDialog
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""
    private var nama = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Creating account In...")
        progressDialog.setCanceledOnTouchOutside(false)

        firebaseAuth = FirebaseAuth.getInstance()

        //handle click, begin signup
        binding.btnRegister.setOnClickListener {
            validateData()
        }

        binding.tvAlreadyHaveAccount.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
//        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
//        btn_register.setOnClickListener {
//            var intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//
//            finish()
//        }
    }

    private fun validateData() {
        //get data
        email = binding.edtEmail.text.toString().trim()
        password = binding.edtPassword.text.toString().trim()

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            //invalid email format
            binding.edtEmail.error = "Invalid email format"
        } else if (TextUtils.isEmpty(password)) {
            //password isn't entered
            binding.edtPassword.error = "Please enter password"
        } else if (password.length < 6) {
            //password length is less than 6
            binding.edtPassword.error = "Password must atleast 6 characters long"
        } else {
            //data is valid, continue signup
            firebaseSignUp()
        }
    }

    private fun firebaseSignUp() {
        //show progress
        progressDialog.show()

        //create account
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //signup success
                progressDialog.dismiss()
                Toast.makeText(this, "Account created", Toast.LENGTH_SHORT).show()

                //open HomePage
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
            .addOnFailureListener { e->
                //signup failed
                progressDialog.dismiss()
                Toast.makeText(this, "SignUp Failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() //go back to previous activity, when back button of actionbar clicked
        return super.onSupportNavigateUp()
    }
}