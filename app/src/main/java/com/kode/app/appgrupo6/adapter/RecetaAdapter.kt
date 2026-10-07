package com.kode.app.appgrupo6.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kode.app.appgrupo6.databinding.ItemRecetaBinding
import com.kode.app.appgrupo6.retrofit.response.Receta


class RecetaAdapter(private val lista: List<Receta>)
    : RecyclerView.Adapter<RecetaAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemRecetaBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecetaAdapter.ViewHolder {
        val binding = ItemRecetaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecetaAdapter.ViewHolder, position: Int) {
        with(holder) {
            with(lista[position]) {
                binding.tvid.text = "ID: $id"
                binding.tvnombre.text = name
                binding.tvtiempo.text = "Tiempo de preparación: $prepTimeMinutes min"
                binding.tvdificultad.text = "Dificultad: $difficulty"
                binding.tvcocina.text = "Cocina: $cuisine"
            }
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}
