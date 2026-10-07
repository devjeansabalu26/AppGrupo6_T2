package com.kode.app.appgrupo6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kode.app.appgrupo6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnIrPregunta2.setOnClickListener {
            val intent = Intent(this, Pregunta2Activity::class.java)
            startActivity(intent)
        }
    }
}