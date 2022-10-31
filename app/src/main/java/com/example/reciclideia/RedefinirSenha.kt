package com.example.reciclideia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RedefinirSenha : AppCompatActivity() {

    private val tag = "RedefinirSenha"
    private var etEmail: EditText? = null
    private var buttonConcluir: Button? = null

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redefinir_senha)
        supportActionBar?.hide()

        inicialise()
    }

    private fun inicialise(){
        etEmail = findViewById(R.id.etEmail) as EditText
        buttonConcluir = findViewById(R.id.buttonConcluir) as Button

        mAuth = FirebaseAuth.getInstance ()

        buttonConcluir!!.setOnClickListener { sendPasswordEmail () }

    }

    private fun sendPasswordEmail () {
        val email = etEmail?.text.toString()

        if (!TextUtils.isEmpty(email)) {
            mAuth!!
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val message = "Email Enviado."
                        Log.d(tag, message)
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                        updateUI()
                    } else {
                        Log.w(tag, task.exception!!.message.toString())
                        Toast.makeText(this,
                            "Nenhum usuário encontrado com esse e-mail.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        } else{
            Toast.makeText (this, "Entre com um e-mail válido", Toast.LENGTH_SHORT).show()
        }
    }
    private fun updateUI(){
        val intent = Intent(this@RedefinirSenha, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}