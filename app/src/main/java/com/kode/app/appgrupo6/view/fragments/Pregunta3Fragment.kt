package com.kode.app.appgrupo6.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kode.app.appgrupo6.databinding.FragmentPregunta3Binding
import java.util.Locale

class Pregunta3Fragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentPregunta3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCalcular.id -> {
                val textoDias = binding.etDiasRetraso.text.toString().trim()

                if (textoDias.isEmpty()) {
                    Toast.makeText(requireContext(), "Ingrese los días de retraso", Toast.LENGTH_SHORT).show()
                    return
                }

                val diasRetraso = textoDias.toIntOrNull()

                if (diasRetraso == null || diasRetraso < 0) {
                    Toast.makeText(requireContext(), "Ingrese una cantidad válida de días", Toast.LENGTH_SHORT).show()
                    return
                }

                if (diasRetraso <= 5) {
                    binding.tvResultado.text = "Entrega dentro de la tolerancia contractual."
                } else {
                    val diasComputables = diasRetraso - 5

                    val penalidad = 500.0 + (diasComputables * 150.0)

                    binding.tvResultado.text = String.format(Locale.US,
                        "Días de retraso: %d\n" +
                                "Días computables para penalidad: %d\n" +
                                "Penalidad resultante: S/ %.2f", diasRetraso, diasComputables, penalidad)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
