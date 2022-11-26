package com.mberrueta.a21_intent_service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartService = findViewById<Button>(R.id.btnStart)
        val btnStopService = findViewById<Button>(R.id.btnStop)
        val tvServiceInfo = findViewById<TextView>(R.id.tvServiceInfo)

        btnStartService.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                tvServiceInfo.text = "Service Running"
            }
        }

        btnStopService.setOnClickListener {
            MyIntentService.stopService()
            tvServiceInfo.text = "Service Stopped"
        }
    }
}

//services -> intent service + semplice
// è su un thread separato
// vive anche quando l'app è minimizzata
// non va bene per multithreading (??)
// se chiudo l'app muore, se è in bg no