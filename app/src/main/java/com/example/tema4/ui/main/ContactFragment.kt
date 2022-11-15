package com.example.tema4.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.tema4.R
import kotlinx.android.synthetic.main.fragment_contact.view.*

class ContactFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        view.backArrowContact_imageView.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_contactFragment1_to_mainFragment) }

        return view

    }
}