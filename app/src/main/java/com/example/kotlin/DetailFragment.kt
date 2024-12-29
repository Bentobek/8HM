package com.example.kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.kotlin.databinding.FragmentDeteilBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDeteilBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDeteilBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val args = DetailFragmentArgs.fromBundle(requireArguments())
            Glide.with(requireContext()).load(args.image).into(binding.ivCakes)
        }
        binding.btnBack.setOnClickListener(){
            findNavController().navigateUp()
        }
        }
    }

