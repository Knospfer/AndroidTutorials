package com.mberrueta.a8_data_between_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //le stringhe sono nullabili, se non ha default sti cazzi non succede niente
//        val name = intent.getStringExtra("EXTRA_NAME")
        //ho il defaul perchè in jva int non è nullabile ma qua si
//        val age = intent.getIntExtra("EXTRA_AGE", 0)
//        val country = intent.getStringExtra("EXTRA_COUNTRY")

        val (name, age, country) = intent.getSerializableExtra("EXTRA_PERSON") as Person
        val personString = "$name is $age years old and lives in $country"

        val tvPerson = findViewById<TextView>(R.id.tvPerson)
        tvPerson.text = personString
    }
}