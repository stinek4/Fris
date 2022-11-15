package com.example.tema4.ui.main.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.tema4.*
import com.example.tema4.database.OrderObject
import kotlinx.android.synthetic.main.fragment_order.*
import kotlinx.android.synthetic.main.fragment_order.view.*


class OrderFragment : Fragment() {

    private lateinit var orderViewModel: OrderViewModel
    private lateinit var notifications: Notifications


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        notifications = Notifications()
        orderViewModel = OrderViewModel()

        view.backArrowOrder_imageView.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_orderFragment_to_burger1Fragment2)
        }

        view.is_imageView.setOnClickListener {
            orderViewModel.addOrderToDB( OrderObject(name = "Ice Cream Roll"))
            notifications.notifyOfAddedOrders("Frys", "Your Item has been added")
            Navigation.findNavController(view).navigate(R.id.action_orderFragment_to_yourOrderFragment)

        }

        view.shakes_imageView.setOnClickListener{
            orderViewModel.addOrderToDB(OrderObject(name = "Shake"))
            notifications.notifyOfAddedOrders("Frys", "Your Item has been added")
            Navigation.findNavController(view).navigate(R.id.action_orderFragment_to_yourOrderFragment)

        }
        view.kaffe_imageView.setOnClickListener {
            orderViewModel.addOrderToDB(OrderObject(name = "Coffee"))
            notifications.notifyOfAddedOrders("Frys", "Your Item has been added")
            Navigation.findNavController(view).navigate(R.id.action_orderFragment_to_yourOrderFragment)

        }

        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        orderViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)


    }

}