package com.mberrueta.a15_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

//Fragments === Components / Widgets -> pezzi di ui riutilizzabili con un loro lifecycle
//posso essere messi staticamente o dinamicamente
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val btnFragment1 = findViewById<Button>(R.id.btnFragment1)
        val btnFragment2 = findViewById<Button>(R.id.btnFragment2)

        //I fragment non hanno uno stack in questo modo, ma si può aggiungere (fatto nella funzione sotto)

        btnFragment1.setOnClickListener {
            applyFragment(firstFragment)
        }

        btnFragment2.setOnClickListener {
            applyFragment(secondFragment)
        }
    }

    private fun applyFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            addToBackStack(null) //così ho uno stack di fragment
            commit() //applica il cambiamento
        }
    }
}