package com.example.reciclideia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase


class Cadastro : AppCompatActivity() {

    private lateinit var edtNome: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtUsuario: EditText
    private lateinit var edtSenha: EditText
    private lateinit var btnCriarConta: Button
    private lateinit var Auth: FirebaseAuth
    //private lateinit var mDbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        Auth = FirebaseAuth.getInstance()
        edtNome = findViewById(R.id.edt_nome)
        edtEmail = findViewById(R.id.edt_email)
        edtUsuario = findViewById(R.id.edt_usuario)
        edtSenha = findViewById(R.id.edt_senha)
        btnCriarConta = findViewById(R.id.btnCriarConta)


        btnCriarConta.setOnClickListener {
            performcriarConta()
        }
    }

    private fun performcriarConta(){
        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtUsuario = findViewById<EditText>(R.id.edt_usuario)
        val edtSenha = findViewById<EditText>(R.id.edt_senha)

        if (edtEmail.text.isEmpty() || edtSenha.text.isEmpty() || edtNome.text.isEmpty()
            || edtUsuario.text.isEmpty()){
            Toast.makeText(this, "Por favor preencha todos os campos", Toast.LENGTH_SHORT)
                .show()
            return
        }
        val email = edtEmail.text.toString()
        val senha = edtSenha.text.toString()

        //criando um usuário
        Auth.createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener(Cadastro()) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        this,
                        "Conta criada com sucesso",Toast.LENGTH_SHORT
                    ).show()
                    // código para ir pra tela principal
                    //addUsuarioToDatabase(nome,email, mAuth.currentUser?.uid!!)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_SHORT).show()
                }
            }

    }

    //private fun addUsuarioToDatabase(nome: String, email: String, uid: String){
        //mDbRef = FirebaseDatabase.getInstance().getReference()
        //mDbRef.child("usuario").child(uid).setValue(Usuario(nome, email, uid))
    //}


    }

//to mudando todas os mAuth para só Auth, se não der certo troca tudo de novo pelo amor

