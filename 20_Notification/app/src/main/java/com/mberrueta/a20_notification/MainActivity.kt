package com.mberrueta.a20_notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    //da oreo in poi si usa un notification channel
    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()

        //pending intent: do la possibilità ad alte app di runnare codice della mia app
        //Mi serve per poter aprire l'app tappando sulla notifica (la mia app di base non lo può fare perchè non è attiva in quel momento)

        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent) //con lo stack posso tornare alle activity precendenti a questa app
            getPendingIntent(
                0,
                PendingIntent.FLAG_MUTABLE
            ) //da versione 31 in poi flag immutable o mutable (non so cosa cambi)
        }


        val btnSend = findViewById<Button>(R.id.btnSend)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("OOOOOOOOO")
            .setContentText("AAAAAAAAA")
            .setSmallIcon(R.drawable.ic_star)
            // non è importance! quella serve per decidere come mostrarla.
            // Questa serve per far decidere il modo in cui schedulare le notifiche che arrivano nello stesso momento
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent) //così posso aprire l'app partendo alla notifica
            .build()
        val notificationManager = NotificationManagerCompat.from(this)


        btnSend.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, notification)
        }


    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //non è necessario in realtà perchè targetto più alto
            //sono da oreo in poi
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT //con higher suona anche
            ).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager //sennò è any!
            manager.createNotificationChannel(channel)
        }
    }
}