package com.kode.app.appgrupo6.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kode.app.appgrupo6.adapter.RecetaAdapter
import com.kode.app.appgrupo6.databinding.FragmentPregunta6Binding
import com.kode.app.appgrupo6.retrofit.ClienteRecetaRetrofit
import com.kode.app.appgrupo6.retrofit.response.ResultReceta
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pregunta6Fragment : Fragment() {
    private var _binding: FragmentPregunta6Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta6Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvrecetas.layoutManager = LinearLayoutManager(requireContext())
        listarRecetas()
    }

    private fun listarRecetas() {
        ClienteRecetaRetrofit.retrofitRecetaService.obtenerRecetas()
            .enqueue(object : Callback<ResultReceta> {
                override fun onResponse(
                    call: Call<ResultReceta>,
                    response: Response<ResultReceta>
                ) {
                    if (_binding == null) return
                    val recetas = response.body()?.recipes
                    if (response.isSuccessful && recetas != null) {
                        binding.rvrecetas.adapter = RecetaAdapter(recetas)
                    } else {
                        Toast.makeText(requireContext(), "No se pudieron obtener las recetas", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResultReceta>, t: Throwable) {
                    if (_binding == null) return
                    Toast.makeText(requireContext(), "Error de conexión: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
