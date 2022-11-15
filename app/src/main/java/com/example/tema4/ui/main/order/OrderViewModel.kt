package com.example.tema4.ui.main.order

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tema4.OrderRepository
import com.example.tema4.database.OrderObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrderViewModel(): ViewModel() {

    private val orderRepository = OrderRepository()

    val isLoading = MutableLiveData(true)
    val ordersLiveData: MutableLiveData<List<OrderObject>> = MutableLiveData()


    fun getOrders() {
        CoroutineScope(Dispatchers.IO).launch{
            val orders = orderRepository.fetchAllOrderItemsFromDB()

            ordersLiveData.postValue(orders)

            if(orders.isEmpty()){
                isLoading.postValue(false)
            }
        }
    }

    fun addOrderToDB(orderObject: OrderObject){
        CoroutineScope(Dispatchers.IO).launch{
            orderRepository.addOrderItemToDB(orderObject)
        }
    }

    fun deleteOrdersFromDB(toDelete: OrderObject){
        CoroutineScope(Dispatchers.IO).launch {
            orderRepository.deleteOrderItemFromDB(toDelete)
            getOrders()
        }
    }
}