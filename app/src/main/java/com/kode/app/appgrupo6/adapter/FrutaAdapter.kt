package com.kode.app.appgrupo6.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kode.app.appgrupo6.databinding.ItemFrutaBinding
import com.kode.app.appgrupo6.model.Fruta

class FrutaAdapter(private val listaFrutas: List<Fruta>) : RecyclerView.Adapter<FrutaAdapter.FrutaViewHolder>() {

    inner class FrutaViewHolder(val binding: ItemFrutaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrutaViewHolder {
        val binding = ItemFrutaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FrutaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FrutaViewHolder, position: Int) {
        val fruta = listaFrutas[position]
        holder.binding.tvNombreFruta.text = fruta.nombre

        Glide.with(holder.itemView.context)
            .load(fruta.urlImagen)
            .into(holder.binding.ivFruta)
    }

    override fun getItemCount(): Int = listaFrutas.size
}