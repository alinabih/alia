package com.example.batarey

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.core.app.NotificationCompat
import com.example.batarey.MyApp.Companion.manager

class MyReceiver : BroadcastReceiver() {



    override fun onReceive(context: Context, intent: Intent) {
//        val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
//            context.registerReceiver(null, ifilter)
//        }
//        val status: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
//        val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING
//        if (isCharging) {
//
//            val builder = NotificationCompat.Builder(context, MyApp.CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_btry)
//                .setContentTitle("Charging ")
//                .setContentText("The charger has been connected successfully")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//
//              manager.notify(1, builder.build())
//
//        } else {
//            val builder = NotificationCompat.Builder(context, MyApp.CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_baseline_battery_6_bar_24)
//                .setContentTitle("Charging ")
//                .setContentText("The charger has been disconnected from the device")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//
//
//              manager.notify(1, builder.build())
//
//        }



        when(intent.action) {

            Intent.ACTION_POWER_CONNECTED -> {
                val notification = NotificationCompat.Builder(context, MyApp.CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_btry)
                    .setContentTitle("Charging ")
                    .setContentText("The charger has been connected successfully")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                manager.notify(1, notification.build())
            }
            Intent.ACTION_POWER_DISCONNECTED -> {

                val notification = NotificationCompat.Builder(context, MyApp.CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_baseline_battery_6_bar_24)
                    .setContentTitle("Charging ")
                    .setContentText("The charger has been disconnected from the device")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                manager.notify(1, notification.build())

            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {

                val notification = NotificationCompat.Builder(context, MyApp.CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_airport_24)
                    .setContentTitle("AirPort ")
                    .setContentText("airPort Conected")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                manager.notify(123, notification.build())

            }



        }


    }



}