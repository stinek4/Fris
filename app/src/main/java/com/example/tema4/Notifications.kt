package com.example.tema4

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color


lateinit var notificationManager: NotificationManager

class Notifications() {
    private var context = FrisApplication.application.applicationContext

    init{
        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createNotificationChannel(
            "ddd",
            "CHANNEL_1",
            "Notification description"
        )
    }

    fun notifyOfAddedOrders(title: String, content: String){
        val notificationID = 101
        val channelID = "ddd"
        val notification = Notification.Builder(context,
            channelID)
            .setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(R.drawable.ice_pink)
            .setChannelId(channelID)
            .build()
        notificationManager?.notify(notificationID, notification)
    }

    private fun createNotificationChannel(id: String, name: String, description: String) {
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(id, name, importance)
        channel.description = description
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        channel.vibrationPattern =
            longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        notificationManager?.createNotificationChannel(channel)
    }
}