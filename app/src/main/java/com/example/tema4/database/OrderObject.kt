package com.example.tema4.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "order_table")
data class OrderObject(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
)

