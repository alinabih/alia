package com.example.batarey

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.example.batarey.MyApp.Companion.manager

class MyApp:Application() {
companion object{
    lateinit var manager: NotificationManager
    val CHANNEL_ID = "ServiceChannelExample"
}

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }


    private fun createNotificationChannel() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(CHANNEL_ID, "Example Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT)
           manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        } else {
            manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }
}

}