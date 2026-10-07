package com.kode.app.appgrupo6

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kode.app.appgrupo6.databinding.ActivityPregunta2Binding

class Pregunta2Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instanciar e inicializar ViewBinding
        binding = ActivityPregunta2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar listener para las pestañas del BottomNavigationView
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_p2 -> {
                    Toast.makeText(this, "Pregunta 2 - Allison", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> true
            }
        }
    }

    // Implementación de la interfaz View.OnClickListener
    override fun onClick(v: View?) {
        // Método de la interfaz disponible para eventos click de la vista
    }
}