package com.kode.app.appgrupo6.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kode.app.appgrupo6.adapter.FrutaAdapter
import com.kode.app.appgrupo6.databinding.FragmentPregunta5Binding
import com.kode.app.appgrupo6.model.Fruta

class Pregunta5Fragment : Fragment() {

    private var _binding: FragmentPregunta5Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta5Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarRecyclerView()
    }

    private fun configurarRecyclerView() {
        val listaFrutas = listOf(
            Fruta("Manzana", "https://picsum.photos/200?random=1"),
            Fruta("Plátano", "https://picsum.photos/200?random=2"),
            Fruta("Naranja", "https://picsum.photos/200?random=3"),
            Fruta("Fresa", "https://picsum.photos/200?random=4"),
            Fruta("Uva", "https://picsum.photos/200?random=5"),
            Fruta("Mango", "https://picsum.photos/200?random=6"),
            Fruta("Piña", "https://picsum.photos/200?random=7"),
            Fruta("Sandía", "https://picsum.photos/200?random=8"),
            Fruta("Melón", "https://picsum.photos/200?random=9"),
            Fruta("Papaya", "https://picsum.photos/200?random=10"),
            Fruta("Kiwi", "https://picsum.photos/200?random=11"),
            Fruta("Pera", "https://picsum.photos/200?random=12"),
            Fruta("Melocotón", "https://picsum.photos/200?random=13"),
            Fruta("Cereza", "https://picsum.photos/200?random=14"),
            Fruta("Ciruela", "https://picsum.photos/200?random=15"),
            Fruta("Frambuesa", "https://picsum.photos/200?random=16"),
            Fruta("Arándano", "https://picsum.photos/200?random=17"),
            Fruta("Limón", "https://picsum.photos/200?random=18"),
            Fruta("Mandarina", "https://picsum.photos/200?random=19"),
            Fruta("Granada", "https://picsum.photos/200?random=20")
        )

        val adaptador = FrutaAdapter(listaFrutas)
        binding.rvFrutas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFrutas.adapter = adaptador
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}