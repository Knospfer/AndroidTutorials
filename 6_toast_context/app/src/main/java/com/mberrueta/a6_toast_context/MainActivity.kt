package com.mberrueta.a6_toast_context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToast = findViewById<Button>(R.id.btnShowToast)

        btnToast.setOnClickListener{
//            Toast.makeText(this, "I'm a toast!", Toast.LENGTH_SHORT).show()
            //se passo l'activity context (this) a un oggetto che deve videre sempre creo un memory leak

            Toast(this).apply {
                duration = Toast.LENGTH_SHORT
                val clToast = findViewById<ViewGroup>(R.id.clToast)
                view = layoutInflater.inflate(R.layout.custom_toast, clToast )
                show()
            }
        }
    }
}