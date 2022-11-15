package com.example.tema4.database.dao

import androidx.core.content.res.FontResourcesParserCompat
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tema4.database.OrderObject

@Dao
interface OrderDAO {
    @Insert
    fun addItem(orderObject: OrderObject)

    @Delete
    fun deleteOrder(orderObject: OrderObject)

    @Query("SELECT * FROM order_table")
    fun getAllItems(): List<OrderObject>
}
