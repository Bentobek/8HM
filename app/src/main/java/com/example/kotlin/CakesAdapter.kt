package com.example.kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.databinding.ItemCakeBinding

class CakesAdapter(val cakesList: ArrayList<Cakes>, val listener:(position: Int) -> Unit) : RecyclerView.Adapter<CakesAdapter.CakesViewHolder>() {
    inner class CakesViewHolder(val binding: ItemCakeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(cakes: Cakes){
            binding.apply{
                tvName.text = cakes.name
                tvDescrition.text = cakes.desc
                tvPrice.text = cakes.price
                Glide.with(itemView).load(cakes.image).into(ivCakes)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesViewHolder {
        val binding = CakesViewHolder(ItemCakeBinding.inflate(LayoutInflater.from(parent.context),parent,false ))
        return binding
    }

    override fun onBindViewHolder(holder: CakesViewHolder, position: Int) {
        holder.bind(cakesList[position ])
        holder.itemView.setOnClickListener {
            listener(position)
        }
     }

    override fun getItemCount(): Int {
        return cakesList.size
    }

}