package com.example.reciclideia

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.reciclideia.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.textViewOuCriarConta.setOnClickListener{
            val intent = Intent(this,Cadastro::class.java)
            startActivity(intent)
        }

        binding.textViewEsqueciMinhaSenha.setOnClickListener{
            val intent = Intent(this,RedefinirSenha::class.java)
            startActivity(intent)
        }

        binding.btnEntrar.setOnClickListener{ view ->
            val email = binding.edtEmail.text.toString()
            val senha = binding.edtSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()){
                val snackbar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                mAuth.let {
                    mAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener { autenticacao ->
                        if (autenticacao.isSuccessful) {
                            navegarTelaPrincipal()
                        }
                    }.addOnFailureListener{
                        val snackbar = Snackbar.make(view, "Erro ao fazer o login do usuário!!", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.RED)
                        snackbar.show()
                    }
                }
                }
            }
        }

    private fun navegarTelaPrincipal(){
        val intent = Intent(this, TelaInicial::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        val usuarioAtual = FirebaseAuth.getInstance().currentUser
        if (usuarioAtual != null) {
            navegarTelaPrincipal()
        }
    }
}












