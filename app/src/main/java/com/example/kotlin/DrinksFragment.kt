package com.example.kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin.databinding.FragmentDrinksBinding

class DrinksFragment : Fragment() {
    private lateinit var binding: FragmentDrinksBinding
    private lateinit var drinksAdapter: DrinksAdapter
    private val drinksList = ArrayList<Drinks>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinksBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoad()
        initRV()
    }

    private fun initRV() {
        drinksAdapter = DrinksAdapter(drinksList){
            val bundle = Bundle()
            bundle.putSerializable("drink", drinksList[it])
            val detaildrinkFragment = DetailDrinkFragment()
            detaildrinkFragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.drinks_fragment_container,detaildrinkFragment).addToBackStack(null).commit()
        }
        binding.rvDrinks.adapter = drinksAdapter
    }

    private fun onLoad(){
        drinksList.add(Drinks(image,"Чай","25","Очень теплый"))
        drinksList.add(Drinks(image4,"Кофе","250","Очень крепкий"))
        drinksList.add(Drinks(image5,"Газировка","240","Очень сладкий"))
    }
}
const val image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzO8OIJz-wvmnD1oQ2Fe_w-q9qR5dH2UYhsg&s"
const val image4 = "https://i.ytimg.com/vi/W7J3rsAzkwg/maxresdefault.jpg"
const val image5 = "data:image/jpeg;base64,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"