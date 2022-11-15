package com.example.tema4

import com.example.tema4.database.AppDatabase
import com.example.tema4.database.OrderObject

class OrderRepository {

    private val database = AppDatabase.getDatabase(FrisApplication.application.applicationContext)
    private val orderDAO = database.orderDAO()

    fun fetchAllOrderItemsFromDB(): List<OrderObject>{
        return orderDAO.getAllItems()
    }

    fun addOrderItemToDB(OrderItemToAdd: OrderObject){
        orderDAO.addItem(OrderItemToAdd)
    }

    fun deleteOrderItemFromDB(ORderItemToDelete: OrderObject){
        orderDAO.deleteOrder(ORderItemToDelete)
    }
}