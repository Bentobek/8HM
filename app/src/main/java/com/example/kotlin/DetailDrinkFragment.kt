package com.example.kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kotlin.databinding.FragmentDetailDrinkBinding
import kotlinx.coroutines.GlobalScope

class DetailDrinkFragment : Fragment() {
    private lateinit var binding: FragmentDetailDrinkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailDrinkBinding.inflate(layoutInflater)
        return binding.root
    }
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null){
            val args: Drinks = requireArguments().getSerializable("drink") as Drinks
        binding.tvName.text = args.nameDrink
        binding.tvDescrition.text = args.descDrink
        binding.tvPrice.text = args.price
        Glide.with(requireContext()).load(args.imageDrinks).into(binding.ivDrinks)
    }
        binding.callButton.setOnClickListener {
            val phoneNumber = "+996705002366"
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(intent)
        }

        binding.whatsappButton.setOnClickListener {
            val phoneNumber = "+996705002366"
            val url = "https://api.whatsapp.com/send?phone=$phoneNumber"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            startActivity(intent)
        }
    }
}