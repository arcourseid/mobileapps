package com.tugas.arcourse1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tugas.arcourse1.databinding.ActivityAvatarBinding
import kotlinx.android.synthetic.main.fragment_editprofil.*

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
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }
    }
}