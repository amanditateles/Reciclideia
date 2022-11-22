package com.example.reciclideia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reciclideia.databinding.ActivityMeuPerfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MeuPerfil : AppCompatActivity() {

    private lateinit var binding: ActivityMeuPerfilBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeuPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        mAuth = Firebase.auth


        binding.imageButtonVoltarMeuPerfil.setOnClickListener{
            finish()
        }

        binding.textViewSair.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val voltarTeladeLogin = Intent(this, MainActivity::class.java)
            startActivity(voltarTeladeLogin)
            finish()
        }

    }

    private fun updateUI(){
        val usuario: FirebaseUser? = mAuth.currentUser
        try {
             binding?.textViewEmail?.text = usuario?.email
        } catch (e : Exception){
            binding?.textViewEmail?.text = ""
        }
    }

    override fun onStart() {
        super.onStart()
        updateUI()
    }

}