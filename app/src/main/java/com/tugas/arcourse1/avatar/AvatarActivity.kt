package com.tugas.arcourse1.avatar

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import com.tugas.arcourse1.R
import com.tugas.arcourse1.databinding.ActivityAvatarBinding
import kotlinx.android.synthetic.main.activity_avatar.*
import kotlinx.android.synthetic.main.activity_avatar.tvNama
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_editprofil.*
import kotlinx.android.synthetic.main.fragment_editprofil.imgProfile
import kotlinx.android.synthetic.main.fragment_editprofil.view.*
import kotlinx.android.synthetic.main.photo_layout.*
import java.io.ByteArrayOutputStream

class AvatarActivity : AppCompatActivity() {

    private val TAG = "AvatarActivity"

    private lateinit var imageUri: Uri
    private lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avatar)

        //Inisialisasi Firebase
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profil")

        //inisialisasi variabel
        val user = auth.currentUser

        val userreference = databaseReference?.child(user?.uid!!)

        //retrieve data dari firebase ke avatar_activity
        userreference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tvNama.text = snapshot.child("Nama Lengkap").value.toString().trim()
                tvKelas.text = snapshot.child("Pendidikan").value.toString().trim()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "loadPost:onCancelled", error.toException())
            }
        })

        //validasi data user
        if (user != null) {
            if (user.photoUrl != null) {
                Picasso.get().load(user.photoUrl).into(imgProfil)
            } else {
                Picasso.get()
                    .load("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png")
                    .into(imgProfil)
            }
        }

        btnEditProfil.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val view = LayoutInflater.from(applicationContext)
                .inflate(
                    R.layout.fragment_editprofil, findViewById(R.id.bottomSheetDialog)
                )

            userreference?.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    view.edtNama.setText(snapshot.child("Nama Lengkap").value.toString().trim())
                    view.edtGender.setText(snapshot.child("Jenis Kelamin").value.toString().trim())
                    view.edtPendidikan.setText(snapshot.child("Pendidikan").value.toString().trim())
                    view.edtPhone.setText(snapshot.child("Nomor Telepon").value.toString().trim())
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w(TAG, "loadPost:onCancelled", error.toException())
                }
            })

            view.imgProfile.setOnClickListener {
                intentCamera()
            }

            view.btnSelesai.setOnClickListener {
                val name = view.edtNama.text.toString().trim()
                val gender = view.edtGender.text.toString().trim()
                val email = view.edtPendidikan.text.toString().trim()
                val phone = view.edtPhone.text.toString().trim()

                if (name.isEmpty()) {
                    view.edtNama.error = "Nama harus diisi"
                    view.edtNama.requestFocus()
                    return@setOnClickListener
                } else if (gender.isEmpty()) {
                    view.edtGender.error = "Gender harus diisi"
                } else if (email.isEmpty()) {
                    view.edtPendidikan.error = "Jenjang Pendidikan harus diisi"
                } else if (phone.isEmpty()) {
                    view.edtPhone.error = "Nomor Telepon harus diisi"
                } else {
                    updateData(name, gender, email, phone)
                    dialog.dismiss()
                }
            }
            dialog.setContentView(view)
            dialog.show()
        }

        imgShop.setOnClickListener {
            startActivity(Intent(this, ShopActivity::class.java))
        }
    }

    private fun updateData(
        nama: String,
        kelamin: String,
        pendidikan: String,
        nomorTelepon: String
    ) {
        databaseReference = FirebaseDatabase.getInstance().getReference("profil")
        val i = auth.currentUser
        val image = when {
            ::imageUri.isInitialized -> imageUri
            i?.photoUrl == null -> Uri.parse("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png")
            else -> i.photoUrl
        }
        val ref = auth.currentUser
        val user = mapOf(
            "Jenis Kelamin" to kelamin,
            "Nama Lengkap" to nama,
            "Pendidikan" to pendidikan,
            "Nomor Telepon" to nomorTelepon
        )
        databaseReference!!.child(ref?.uid!!).updateChildren(user)
        UserProfileChangeRequest.Builder()
            .setPhotoUri(image)
            .build().also {
                i?.updateProfile(it)?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Update Sukses", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Update Gagal", Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }

    val getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val imgBitmap = it?.data?.extras?.get("data") as Bitmap
        uploadImage(imgBitmap)
    }

    private fun uploadImage(imgBitmap: Bitmap) {
        val bags = ByteArrayOutputStream()
        val view = LayoutInflater.from(applicationContext)
            .inflate(
                R.layout.fragment_editprofil, findViewById(R.id.bottomSheetDialog)
            )
        val ref =
            FirebaseStorage.getInstance().reference.child("img/${FirebaseAuth.getInstance().currentUser?.uid}")

        imgBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bags)
        val image = bags.toByteArray()

        ref.putBytes(image)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    ref.downloadUrl.addOnCompleteListener {
                        it.result?.let {
                            imageUri = it
                            view.imgProfile.setImageBitmap(imgBitmap)
                            imgProfil.setImageBitmap(imgBitmap)
                        }
                    }
                }
            }
    }

    private fun intentCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
            this@AvatarActivity.packageManager?.let {
                intent.resolveActivity(it).also {
                    getAction.launch(intent)
                }
            }
        }
    }
}