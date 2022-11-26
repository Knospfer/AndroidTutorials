package com.mberrueta.a7_intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOpenActivity = findViewById<Button>(R.id.btnOpenActivity)

        btnOpenActivity.setOnClickListener{
            //intent -> perform a specific action (posono essere tante diverse)
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}