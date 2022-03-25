package com.example.ladm_u2_practica2_loteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val data:List<Carta>) : RecyclerView.Adapter<CustomAdapter.mazoViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): mazoViewHolder{
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view, viewGroup, false)
        return mazoViewHolder(v)
    }

    override fun onBindViewHolder(holder: mazoViewHolder, i: Int) {
        val item = data[i]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class mazoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage = itemView.findViewById<ImageView>(R.id.cartas)

        fun render(carta: Carta){
            itemImage.setImageResource(carta.imagen)
        }
    }
}