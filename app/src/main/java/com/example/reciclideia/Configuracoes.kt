package com.example.reciclideia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reciclideia.databinding.ActivityConfiguracoesBinding
import com.google.firebase.auth.FirebaseAuth

class Configuracoes : AppCompatActivity() {

    private lateinit var binding: ActivityConfiguracoesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfiguracoesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imageButtonVoltar.setOnClickListener{
            finish()
        }

        binding.textViewSair.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val voltarTeladeLogin = Intent(this, MainActivity::class.java)
            startActivity(voltarTeladeLogin)
            finish()
        }
    }
}

