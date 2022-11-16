package com.example.reciclideia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.reciclideia.databinding.ActivityExcluirContaBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser



class ExcluirConta : AppCompatActivity() {

    private lateinit var binding: ActivityExcluirContaBinding
    private lateinit var mAuth : FirebaseAuth
    private lateinit var firebaseUser : FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExcluirContaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()
        firebaseUser = mAuth.currentUser!!

        binding.imageButtonVoltarExcluirConta.setOnClickListener{
            finish()
        }

        binding.btnExcluir.setOnClickListener{

            firebaseUser.delete().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        //conta acabou de ser deletada
                        Toast.makeText(this, "Conta Deletada", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText (this, "Ocorreu um erro ok", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }

}

