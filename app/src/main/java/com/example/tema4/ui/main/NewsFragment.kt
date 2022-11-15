package com.example.tema4.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.tema4.MainActivity
import com.example.tema4.R
import kotlinx.android.synthetic.main.fragment_news.view.*
import kotlinx.android.synthetic.main.fragment_order.view.*

class NewsFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View {
            val view = inflater.inflate(R.layout.fragment_news, container, false)

            view.backArrowNews_imageView.setOnClickListener {
                Navigation.findNavController(view)
                    .navigate(R.id.action_newsFragment_to_burgerFragment)
            }
            return view
        }
}