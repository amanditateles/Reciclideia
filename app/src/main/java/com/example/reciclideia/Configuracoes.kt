package com.example.reciclideia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Configuracoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracoes)

        val imageButtonVoltar = findViewById<ImageButton>(R.id.imageButtonVoltar)
        imageButtonVoltar.setOnClickListener {
            openActivity()
        }

        val buttonFazerPostagem = findViewById<Button>(R.id.buttonFazerPostagem)
        buttonFazerPostagem.setOnClickListener {
            openSecondActivity()
        }

    }
        private fun openActivity(){
            val intent = Intent(this, TelaInicial::class.java)
            startActivity(intent)
        }

        private fun openSecondActivity(){
        val intent = Intent(this, PostarConfeccoes::class.java)
        startActivity(intent)
    }

}