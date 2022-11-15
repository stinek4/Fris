package com.example.tema4.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tema4.database.dao.OrderDAO

@Database(entities = [OrderObject::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    //Initializing DAOs
    abstract fun orderDAO(): OrderDAO


    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}