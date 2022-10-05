package com.example.reciclideia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MeuAdapter (private val listaDeIdeias : ArrayList<Ideias>) : RecyclerView.Adapter<MeuAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lista_de_ideias,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemAtual = listaDeIdeias [position]
        holder.titleImage.setImageResource(itemAtual.titleimage)
        holder.cabecalho.text = itemAtual.cabecalho


    }

    override fun getItemCount(): Int {
        return listaDeIdeias.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val cabecalho : TextView = itemView.findViewById(R.id.textViewCabecalho)

    }

}