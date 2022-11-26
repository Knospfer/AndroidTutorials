package com.mberrueta.a13_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customList = listOf("Fisrt", "Second", "Third")
        val adapter = ArrayAdapter<String>(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            customList
        )


        val spMonths = findViewById<Spinner>(R.id.spMonths)
        spMonths.adapter = adapter //così uso la mia custom list sennò uso le stringhe statiche

        spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //anonymous class
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
                //non la uso perchè ho sempre un elemento selezionato nel mio caso
            }

            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //!!! il this è la classe anonima qua occhio
                Toast.makeText(
                    this@MainActivity,
                    "You selected ${adapterView?.getItemAtPosition(position)}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}