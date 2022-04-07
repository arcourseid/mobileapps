package com.tugas.arcourse1.modul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tugas.arcourse1.HomeActivity
import com.tugas.arcourse1.R
import com.tugas.arcourse1.modul.fragmentModul.ModulBalok
import com.tugas.arcourse1.modul.fragmentModul.ModulKubus
import com.tugas.arcourse1.modul.fragmentModul.ModulLimas
import com.tugas.arcourse1.modul.fragmentModul.ModulLingkaran
import kotlinx.android.synthetic.main.activity_modul.*

class ModulActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_modul)

        val modulKubus = ModulKubus()
        val modulBalok = ModulBalok()
        val modulLimas = ModulLimas()
        val modulLingkaran = ModulLingkaran()

        val bundle: Bundle? = intent.extras
        val modul = bundle?.get("modul")

        if (modul == 1) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentModul, modulKubus)
                commit()
            }
        } else if (modul == 2) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentModul, modulBalok)
                commit()
            }
        } else if (modul == 3) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentModul, modulLimas)
                commit()
            }
        } else if (modul == 4) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentModul, modulLingkaran)
                commit()
            }
        }
    }
}