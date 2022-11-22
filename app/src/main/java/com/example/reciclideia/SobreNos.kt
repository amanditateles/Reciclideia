package com.example.reciclideia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reciclideia.databinding.ActivityCadastroBinding
import com.example.reciclideia.databinding.ActivitySobreNosBinding

class SobreNos : AppCompatActivity() {

    private lateinit var binding: ActivitySobreNosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySobreNosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imageButtonVoltarSobreNos.setOnClickListener{
            finish()
        }

    }
}