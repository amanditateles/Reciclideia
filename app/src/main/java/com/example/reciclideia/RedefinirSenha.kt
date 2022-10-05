package com.example.reciclideia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RedefinirSenha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redefinir_senha)

        val buttonConcluir = findViewById<Button>(R.id.buttonConcluir)
        buttonConcluir.setOnClickListener{
            openActivity()
        }
    }
    private fun openActivity(){
        val intent = Intent(this, TelaInicial::class.java)
        startActivity(intent)
    }
}