package com.mberrueta.a22_services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnStop = findViewById<Button>(R.id.btnStop)
        val btnSendData = findViewById<Button>(R.id.btnSendData)

        val tvServiceInfo = findViewById<TextView>(R.id.tvServiceInfo)
        val etData = findViewById<EditText>(R.id.etData)

        btnStart.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                tvServiceInfo.text = "Service Running"
            }
        }

        btnStop.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it) //meglio del singleton secondo me
                tvServiceInfo.text = "Service stopped"
            }
        }

        btnSendData.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = etData.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
            }
        }
    }
}

/**
 * Questa è la superclasse dell'Intent Service
 * **/