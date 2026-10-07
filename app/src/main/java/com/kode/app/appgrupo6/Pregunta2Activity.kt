package com.kode.app.appgrupo6

import android.os.Bundle
import android.view.View
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

        val pregunta = intent.getIntExtra("pregunta", 0)

        configurarMenu(pregunta)
    }

    private fun configurarMenu(pregunta: Int) {

        binding.bottomNavigation.menu.findItem(R.id.nav_p3).isVisible = false
        binding.bottomNavigation.menu.findItem(R.id.nav_p4).isVisible = false
        binding.bottomNavigation.menu.findItem(R.id.nav_p5).isVisible = false
        binding.bottomNavigation.menu.findItem(R.id.nav_p6).isVisible = false

        when (pregunta) {

//            1 -> {
//                mostrarFragmento(Pregunta1Fragment())
//
//                // Si tu menu tiene nav_p1:
//                binding.bottomNavigation.menu
//                    .findItem(R.id.nav_p1)
//                    .isVisible = true
//
//                binding.bottomNavigation.selectedItemId = R.id.nav_p1
//            }

//            2 -> {
//                mostrarFragmento(Pregunta2Fragment())
//
//                // Si tu menu tiene nav_p2:
//                binding.bottomNavigation.menu
//                    .findItem(R.id.nav_p2)
//                    .isVisible = true
//
//                binding.bottomNavigation.selectedItemId = R.id.nav_p2
//            }

            4 -> {
                mostrarFragmento(Pregunta4Fragment())

                // Mostrar únicamente Pregunta 4
                binding.bottomNavigation.menu
                    .findItem(R.id.nav_p4)
                    .isVisible = true

                binding.bottomNavigation.selectedItemId = R.id.nav_p4
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->

            when (item.itemId) {

//                R.id.nav_p1 -> {
//                    mostrarFragmento(Pregunta1Fragment())
//                    true
//                }
//
//                R.id.nav_p2 -> {
//                    mostrarFragmento(Pregunta2Fragment())
//                    true
//                }

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

                else -> false
            }
        }
    }

    private fun mostrarFragmento(fragment: Fragment) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun onClick(v: View?) {
        // Eventos de botones
    }
}