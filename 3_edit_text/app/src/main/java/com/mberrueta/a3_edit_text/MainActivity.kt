package com.mberrueta.a3_edit_text

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val etFirstDigit = findViewById<EditText>(R.id.etFirstDigit)
        val etSecondDigit = findViewById<EditText>(R.id.etSecondDigit)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnAdd.setOnClickListener {
            val firstDigit = etFirstDigit.text.toString()
            val secondDigit = etSecondDigit.text.toString()

            val result = firstDigit.toInt() + secondDigit.toInt()

            tvResult.text = "Risultato: $result"
        }
    }
}