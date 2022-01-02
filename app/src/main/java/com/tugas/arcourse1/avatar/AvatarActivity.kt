package com.tugas.arcourse1.avatar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tugas.arcourse1.R
import com.tugas.arcourse1.databinding.ActivityAvatarBinding

class AvatarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAvatarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvatarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEditProfil.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(
                this, R.style.BottomSheetDialogTheme
            )

            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.fragment_editprofil,
                findViewById(R.id.bottomSheetDialog)
            )

            bottomSheetView.findViewById<View>(R.id.btnSelesai).setOnClickListener {
                bottomSheetDialog.dismiss()
            }

            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }

        binding.imgShop.setOnClickListener {
            startActivity(Intent(this, ShopActivity::class.java))
        }
    }
}