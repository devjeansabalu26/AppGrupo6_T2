package com.kode.app.appgrupo6

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.kode.app.appgrupo6.databinding.ActivityPregunta3Binding
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class Pregunta3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPregunta3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            binding.btnCalcular.id -> {
                val textoDias = binding.etDiasRetraso.text.toString().trim()

                if(textoDias.isEmpty()){
                    Toast.makeText(this, "Ingrese los dias de retraso", Toast.LENGTH_SHORT).show()
                    return
                }

                val diasRetraso = textoDias.toIntOrNull()

                if (diasRetraso == null || diasRetraso < 0){
                    Toast.makeText(this, "Ingrese una cantidad valida de dias", Toast.LENGTH_SHORT).show()
                    return
                }

                if (diasRetraso <= 5){
                    binding.tvResultado.text = "Entrega dentro de la tolerancia contractual."
                } else {
                    val diasComputables = diasRetraso - 5

                    val penalidad = 500.0 + (diasComputables * 150.0)

                    binding.tvResultado.text = String.format(Locale.US,
                        "Dias de retraso: %d\n" +
                                "Dias computables para penalidad: %d\n" +
                                "Penalidad: S/ %.2f", diasRetraso, diasComputables, penalidad)
                }
            }
        }
    }


    }
