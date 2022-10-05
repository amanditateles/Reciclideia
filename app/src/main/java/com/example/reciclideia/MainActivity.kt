package com.example.reciclideia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtSenha: EditText
    private lateinit var btnEntrar: Button
    private lateinit var btnCriarConta: Button
    private lateinit var btnEsqueciMinhaSenha: Button
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.edt_email)
        edtSenha = findViewById(R.id.edt_senha)
        btnEntrar = findViewById(R.id.btn_entrar)
        btnCriarConta = findViewById(R.id.btnCriarConta)
        btnEsqueciMinhaSenha = findViewById(R.id.btnEsqueciMinhaSenha)

        mAuth = FirebaseAuth.getInstance()

        btnCriarConta.setOnClickListener{
            val intent = Intent(this,Cadastro::class.java)
            startActivity(intent)
        }

        btnEsqueciMinhaSenha.setOnClickListener{
            val intent = Intent(this,RedefinirSenha::class.java)
            startActivity(intent)
        }


        btnEntrar.setOnClickListener{
            val email = edtEmail.text.toString()
            val senha = edtSenha.text.toString()

            entrar(email,senha);
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








