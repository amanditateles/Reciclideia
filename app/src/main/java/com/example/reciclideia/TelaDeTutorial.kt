package com.example.reciclideia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class TelaDeTutorial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_tutorial)

        val cabecalhoIdeias : TextView = findViewById(R.id.cabecalho)
        val mainTutoriais : TextView = findViewById(R.id.textViewTutorial)
        val imagemIdeias : ImageView = findViewById(R.id.imagemTutorial)

        val bundle : Bundle? = intent.extras
        val cabecalho = bundle!!.getString("cabecalho")
        val imageId = bundle.getInt("imageId")
        val ideias = bundle.getString("ideias")

        cabecalhoIdeias.text = cabecalho
        mainTutoriais.text = ideias
        imagemIdeias.setImageResource(imageId)
    }
}