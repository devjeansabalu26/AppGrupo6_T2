package com.kode.app.appgrupo6.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kode.app.appgrupo6.databinding.FragmentPregunta4Binding
import java.util.Locale

class Pregunta4Fragment : Fragment() {

    private var _binding: FragmentPregunta4Binding? = null
    private val binding get() = _binding!!

    // Valores establecidos por el ejercicio
    private val limiteMerma = 10
    private val costoBase = 100.00
    private val costoPorPrenda = 28.00

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPregunta4Binding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalcularMerma.setOnClickListener {
            calcularMerma()
        }
    }

    private fun calcularMerma() {

        val textoPrendas = binding.etPrendasDefectuosas.text.toString().trim()

        // Validar que el usuario haya ingresado un valor
        if (textoPrendas.isEmpty()) {

            Toast.makeText(
                requireContext(),
                "Ingrese la cantidad de prendas defectuosas",
                Toast.LENGTH_SHORT
            ).show()

            return
        }


        val prendasDefectuosas = textoPrendas.toIntOrNull()

        // Validar que sea un número válido
        if (prendasDefectuosas == null) {

            Toast.makeText(
                requireContext(),
                "Ingrese una cantidad válida",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        // Validar que no sea negativo
        if (prendasDefectuosas < 0) {

            Toast.makeText(
                requireContext(),
                "La cantidad no puede ser negativa",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        // Mostrar cantidad de fallas
        binding.tvFallasRegistradas.text =
            prendasDefectuosas.toString()

        // Caso 1: dentro del margen permitido
        if (prendasDefectuosas <= limiteMerma) {

            binding.tvMensaje.text =
                "Nivel de merma dentro del margen admisible."

            binding.tvExcesoPrendas.text = "0" // error todos son textview

            binding.tvDescuentoTotal.text =
                String.format(Locale.US, "S/ %.2f", 0.0)

        } else {

            // Calcular exceso
            val excesoPrendas =
                prendasDefectuosas - limiteMerma

            // Calcular descuento
            val descuentoTotal =
                costoBase + (excesoPrendas * costoPorPrenda)

            // Mostrar mensaje
            binding.tvMensaje.text =
                "Nivel de merma excede el margen admisible."

            // Mostrar exceso
            binding.tvExcesoPrendas.text =
                excesoPrendas.toString()

            // Mostrar descuento
            binding.tvDescuentoTotal.text =
                String.format(
                    Locale.US,
                    "S/ %.2f",
                    descuentoTotal
                )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}