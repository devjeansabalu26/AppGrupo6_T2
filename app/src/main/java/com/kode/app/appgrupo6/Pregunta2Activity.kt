package com.kode.app.appgrupo6

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kode.app.appgrupo6.databinding.ActivityPregunta2Binding
import com.kode.app.appgrupo6.view.fragments.Pregunta3Fragment
import com.kode.app.appgrupo6.view.fragments.Pregunta4Fragment
import com.kode.app.appgrupo6.view.fragments.Pregunta5Fragment
import com.kode.app.appgrupo6.view.fragments.Pregunta6Fragment

class Pregunta2Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityPregunta2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_p3 -> {
                    mostrarFragmento(Pregunta3Fragment())
                    true
                }
                R.id.nav_p4 -> {
                    mostrarFragmento(Pregunta4Fragment())
                    true
                }
                R.id.nav_p5 -> {
                    mostrarFragmento(Pregunta5Fragment())
                    true
                }
                R.id.nav_p6 -> {
                    mostrarFragmento(Pregunta6Fragment())
                    true
                }
                else -> true
            }
        }
        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.nav_p3
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