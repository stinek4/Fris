package com.example.tema4.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.tema4.R
import kotlinx.android.synthetic.main.fragment_burger.view.*

class BurgerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_burger, container, false)

        view.scraperOpen_imageView.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_backScraperfromBurger) }

        view.meny_button.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_burger1Fragment2_to_carteFragment)
        }

        view.bestille_button.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_burger1Fragment2_to_orderFragment2)
        }

        view.kontakt_button.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_burger1Fragment2_to_contactFragment1)
        }

        view.nyhet_button.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_burger1Fragment2_to_newsFragment)
        }

        return view

    }

}