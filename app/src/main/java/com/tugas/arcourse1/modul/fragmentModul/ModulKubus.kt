package com.tugas.arcourse1.modul.fragmentModul

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tugas.arcourse1.HomeActivity
import com.tugas.arcourse1.R
import com.tugas.arcourse1.modul.QuizActivity
import kotlinx.android.synthetic.main.fragment_modul_balok.view.btn_modul
import kotlinx.android.synthetic.main.selesaimodul.view.*

class ModulKubus : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_modul_kubus, container, false)

        view.btn_modul.setOnClickListener {
            val v = View.inflate(activity, R.layout.selesaimodul, null)
            val builder = AlertDialog.Builder(activity)
            builder.setView(v)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setCanceledOnTouchOutside(true)

            v.btnKuis.setOnClickListener { v ->
                val intent = Intent(activity, QuizActivity::class.java)
                intent.putExtra("quiz", 1)
                startActivity(intent)
            }

            v.imgCancel.setOnClickListener {
                startActivity(Intent(activity, HomeActivity::class.java))
            }
        }

        return view
    }
}