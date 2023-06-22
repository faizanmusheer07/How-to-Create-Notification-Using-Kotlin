package com.example.notification_using_kotlin

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class channel: Application() {
   public final val channel_ID1 = "Channnel1"
    public final  val channel_ID2 = "Channnel2"
    override fun onCreate() {
        super.onCreate()
if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
    val channel1= NotificationChannel(channel_ID1,
    "Images", NotificationManager.IMPORTANCE_HIGH)
    channel1.description= "This is My Important Notifications"
    val channel2= NotificationChannel(channel_ID2,
    "location", NotificationManager.IMPORTANCE_DEFAULT)
    channel2.description= "This is My  Defalut  Important Notifications"
    val manager =  getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    manager.createNotificationChannel(channel1)
    manager.createNotificationChannel(channel2)

}
    }

}