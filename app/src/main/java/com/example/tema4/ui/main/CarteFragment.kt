package com.example.tema4.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.tema4.R
import kotlinx.android.synthetic.main.fragment_carte.view.*

class CarteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_carte, container, false)


        hiddenMenuViews(view)
        setOnClickListeners(view)

        return view

    }

    private fun setOnClickListeners(view: View){

        view.go2order_button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_carteFragment_to_orderFragment) }

        view.velgsmak_iceCream_textView.setOnClickListener {
            view.iceCreamFlavourOne_textView.visibility = View.VISIBLE
            view.iceCreamFlavourTwo_textView.visibility = View.VISIBLE
            view.iceCreamFlavourThree_textView.visibility = View.VISIBLE
            view.click_imageView.visibility = View.GONE
        }
        view.velgtilsetning_textView.setOnClickListener {
            view.tilsetningOne_textView.visibility = View.VISIBLE
            view.tilsetningTwo_textView.visibility = View.VISIBLE
            view.tilsetningThree_textView.visibility = View.VISIBLE
            view.tilsetningFour_textView.visibility = View.VISIBLE
            view.click_imageView.visibility = View.GONE
        }
        view.velgTopping_textView.setOnClickListener {
            view.toppingOne_textView.visibility = View.VISIBLE
            view.toppingTwo_textView.visibility = View.VISIBLE
            view.toppingThree_textView.visibility = View.VISIBLE
            view.toppingFour_textView.visibility = View.VISIBLE
            view.click_imageView.visibility = View.GONE
        }
        view.velgSmak_textView.setOnClickListener {
            view.shakeFlavourOne_textView.visibility = View.VISIBLE
            view.shakeFlavourTwo_textView.visibility = View.VISIBLE
            view.shakeFlavourThree_textView.visibility = View.VISIBLE
            view.click_imageView.visibility = View.GONE
        }
        view.velgType_textView.setOnClickListener {
            view.coffeeTypeOne_textView.visibility = View.VISIBLE
            view.coffeeTypeTwo_textView.visibility = View.VISIBLE
            view.coffeeTypeThree_textView.visibility = View.VISIBLE
            view.click_imageView.visibility = View.GONE
        }
    }

    private fun hiddenMenuViews(view: View){
        view.iceCreamFlavourOne_textView.visibility = View.GONE
        view.iceCreamFlavourTwo_textView.visibility = View.GONE
        view.iceCreamFlavourThree_textView.visibility = View.GONE
        view.tilsetningOne_textView.visibility = View.GONE
        view.tilsetningTwo_textView.visibility = View.GONE
        view.tilsetningThree_textView.visibility = View.GONE
        view.tilsetningFour_textView.visibility = View.GONE
        view.toppingOne_textView.visibility = View.GONE
        view.toppingTwo_textView.visibility = View.GONE
        view.toppingThree_textView.visibility = View.GONE
        view.toppingFour_textView.visibility = View.GONE
        view.shakeFlavourOne_textView.visibility = View.GONE
        view.shakeFlavourTwo_textView.visibility = View.GONE
        view.shakeFlavourThree_textView.visibility = View.GONE
        view.coffeeTypeOne_textView.visibility = View.GONE
        view.coffeeTypeTwo_textView.visibility = View.GONE
        view.coffeeTypeThree_textView.visibility = View.GONE
    }
}