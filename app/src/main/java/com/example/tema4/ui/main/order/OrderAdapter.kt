package com.example.tema4.ui.main.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tema4.FrisApplication
import com.example.tema4.OrderRepository
import com.example.tema4.R
import com.example.tema4.database.OrderObject
import com.example.tema4.database.dao.OrderDAO
import java.util.concurrent.RecursiveAction

class OrderAdapter(
    private var dataSet : List<OrderObject>)
    : RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    var orderViewModel = OrderViewModel()
    var yourOrderFragment = YourOrderFragment()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            var orderName: TextView = view.findViewById(R.id.yourOrderType_textView)
            var numberOrder: TextView = view.findViewById(R.id.placeholderNumber_textView)
            var plusButton: TextView = view.findViewById(R.id.plus_button)
            var minusButton: TextView = view.findViewById(R.id.minus_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(FrisApplication.application.applicationContext)
            .inflate(R.layout.your_order_card, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var order = dataSet[position]
        holder.orderName.text = order.name
        holder.numberOrder.text = "1"

        holder.minusButton.setOnClickListener {
            var amount = holder.numberOrder.text.toString()
            var newAmount = minus(amount, order)

            holder.numberOrder.text = newAmount
                if (newAmount == "0"){
                    orderViewModel.deleteOrdersFromDB(order)
                    notifyItemChanged(holder.adapterPosition)
                    notifyItemRemoved(holder.layoutPosition)
                }
        }

        holder.plusButton.setOnClickListener {
            var amount = holder.numberOrder.text.toString()
            var newAmount = plus(amount)
            holder.numberOrder.text = newAmount
        }
    }


    fun updateData(list: List<OrderObject>){
        dataSet = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int{
        return dataSet.size
    }

    fun plus(i: String): String{
        val f = i.toInt() + 1
        return f.toString()
    }

    fun minus(i: String, order: OrderObject): String{
        val f = i.toInt() - 1
        return f.toString()
    }
}