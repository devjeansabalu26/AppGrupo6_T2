package com.kode.app.appgrupo6

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kode.app.appgrupo6.databinding.ActivityPregunta2Binding
import com.kode.app.appgrupo6.view.fragments.Pregunta1Fragment
import com.kode.app.appgrupo6.view.fragments.Pregunta2Fragment
import com.kode.app.appgrupo6.view.fragments.Pregunta3Fragment
import com.kode.app.appgrupo6.view.fragments.Pregunta4Fragment

class Pregunta2Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityPregunta2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_p1 -> {
                    mostrarFragmento(Pregunta1Fragment())
                    true
                }
                R.id.nav_p2 -> {
                    Toast.makeText(this, "Pregunta 2 - Allison", Toast.LENGTH_SHORT).show()
                    mostrarFragmento(Pregunta2Fragment())
                    true
                }
                R.id.nav_p3 -> {
                    mostrarFragmento(Pregunta3Fragment())
                    true
                }
                R.id.nav_p4 -> {
                    mostrarFragmento(Pregunta4Fragment())
                    true
                }
                else -> true
            }
        }
        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.nav_p1
        }
    }

    private fun mostrarFragmento(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }


    override fun onClick(v: View?) {
        //eventos de click de boto pregunt
    }
}