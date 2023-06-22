package com.example.notification_using_kotlin

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.notification_using_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.high.setOnClickListener {
            val notification = NotificationCompat.Builder(this, channel().channel_ID1)
            notification.setContentTitle(binding.title.text.toString())
            notification.setContentText(binding.content.text.toString())
            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent= PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            notification.setSmallIcon(R.drawable._android_black)
            notification.setPriority(NotificationCompat.PRIORITY_HIGH)

                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.MAGENTA)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable._android_black, "Read All", pendingIntent)
                .addAction(R.drawable._android_black, "Show", null)
                .addAction(R.drawable._android_black, "Cancel", null)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(7, notification.build())
        }
        binding.low.setOnClickListener {
            val notification = NotificationCompat.Builder(this, channel().channel_ID2)
            notification.setContentTitle(binding.title.text.toString())
            notification.setContentText(binding.content.text.toString())
            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_IMMUTABLE )
            notification.setSmallIcon(R.drawable._android_black)
            notification.setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.MAGENTA)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable._android_black, "Read All", pendingIntent)
                .addAction(R.drawable._android_black, "Show", null)
                .addAction(R.drawable._android_black, "Cancel", null)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(8, notification.build())
        }
    }
}