package com.example.kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.databinding.ItemCakeBinding

class   LottiAdapter(val lotttiList: ArrayList<Lottti>, val listener:(position: Int) -> Unit) : RecyclerView.Adapter<LottiAdapter.CakesViewHolder>() {
    inner class CakesViewHolder(val binding: ItemCakeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(lottti: Lottti){
            binding.apply{
                Glide.with(itemView).load(lottti.image).into(ivCakes)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesViewHolder {
        val binding = CakesViewHolder(ItemCakeBinding.inflate(LayoutInflater.from(parent.context),parent,false ))
        return binding
    }

    override fun onBindViewHolder(holder: CakesViewHolder, position: Int) {
        holder.bind(lotttiList[position ])
        holder.itemView.setOnClickListener {
            listener(position)
        }
     }

    override fun getItemCount(): Int {
        return lotttiList.size
    }

}