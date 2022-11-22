package com.example.reciclideia

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.reciclideia.databinding.ActivityCadastroBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException


class Cadastro : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imageButtonVoltarCriarConta.setOnClickListener{
            finish()
        }


        binding.btnCriarConta.setOnClickListener {view ->

            val email = binding.edtEmail.text.toString()
            val senha = binding.edtSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()){
                val snackbar = Snackbar.make(view, "Preencha todos os campos!",Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }else{
                mAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(Cadastro()) { cadastro ->
                    if (cadastro.isSuccessful) {
                        val snackbar = Snackbar.make(view, "Conta criada com sucesso!",Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.BLUE)
                        snackbar.show()
                        navegarMainActivity()

                    }
                 }.addOnFailureListener{ exception ->

                     val mensagemErro = when(exception){
                         is FirebaseAuthWeakPasswordException -> "Digite uma senha com no mínimo 6 caracteres!"
                         is FirebaseAuthInvalidCredentialsException -> "Digite um email válido!"
                         is FirebaseAuthUserCollisionException -> "Esta conta já foi cadastrada!"
                         is FirebaseNetworkException -> "Sem conexão com a internet!"
                         else -> "Erro ao cadastrar usuário!"
                     }
                    val snackbar = Snackbar.make(view,mensagemErro,Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }
            }
        }
    }

    private fun navegarMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}




