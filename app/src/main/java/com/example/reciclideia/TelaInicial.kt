package com.example.reciclideia


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaInicial : AppCompatActivity() {

    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
        replaceFragment(IdeiasFragment())

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.telaInicialContainer) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottonNavigationView)
        setupWithNavController(bottomNavigationView, navController)
    }
  
    private fun replaceFragment(ideiasFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, ideiasFragment)
        fragmentTransaction.commit()
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_meu_perfil -> {
                startActivity(Intent(this, MeuPerfil::class.java))
                true
            }

            R.id.item_excluir_conta -> {
                startActivity(Intent(this, ExcluirConta::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_opcoes,menu)
        return true
    }


}

