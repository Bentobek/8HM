package com.example.kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.databinding.ItemDrinkBinding

class DrinksAdapter (val drinkList: ArrayList<Drinks>, val listener:(position: Int) -> Unit) : RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder>(){
    inner class DrinksViewHolder(val binding: ItemDrinkBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(drinks: Drinks){
            binding.apply{
                tvName.text = drinks.nameDrink
                tvDescrition.text = drinks.descDrink
                tvPrice.text = drinks.price
                Glide.with(itemView).load(drinks.imageDrinks).into(ivDrinks)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):DrinksViewHolder{
        val binding = DrinksViewHolder(ItemDrinkBinding.inflate(LayoutInflater.from(parent.context),parent,false ))
        return binding
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        holder.bind(drinkList[position])
        holder.itemView.setOnClickListener {
            listener(position)
        }
    }


    override fun getItemCount(): Int {
        return drinkList.size
    }

}