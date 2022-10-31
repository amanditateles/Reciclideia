package com.example.reciclideia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtSenha: EditText
    private lateinit var btnEntrar: Button
    private lateinit var textViewOuCriarConta: TextView
    private lateinit var textViewEsqueciMinhaSenha: TextView
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        edtEmail = findViewById(R.id.edt_email)
        edtSenha = findViewById(R.id.edt_senha)
        btnEntrar = findViewById(R.id.btn_entrar)
        textViewOuCriarConta = findViewById(R.id.textViewOuCriarConta)
        textViewEsqueciMinhaSenha = findViewById(R.id.textViewEsqueciMinhaSenha)

        mAuth = FirebaseAuth.getInstance()

        textViewOuCriarConta.setOnClickListener{
            val intent = Intent(this,Cadastro::class.java)
            startActivity(intent)
        }

        textViewEsqueciMinhaSenha.setOnClickListener{
            val intent = Intent(this,RedefinirSenha::class.java)
            startActivity(intent)
        }


        btnEntrar.setOnClickListener{
            val email = edtEmail.text.toString()
            val senha = edtSenha.text.toString()

            entrar(email,senha)
        }


    }

    private fun entrar(email: String, senha: String){
        //logando um usuário
        if (edtEmail.text.isEmpty() || edtSenha.text.isEmpty()){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT)
                .show()
            return
        }


        mAuth.signInWithEmailAndPassword(email, senha)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // logar usuário
                    val intent = Intent(this@MainActivity, TelaInicial::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@MainActivity, "Usuário não existe", Toast.LENGTH_SHORT).show()
                }
            }

    }

        }








