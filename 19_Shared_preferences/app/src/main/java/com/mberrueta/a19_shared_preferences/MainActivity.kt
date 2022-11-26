package com.mberrueta.a19_shared_preferences

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnLoad = findViewById<Button>(R.id.btnLoad)
        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val cbAdult = findViewById<CheckBox>(R.id.cbAdult)

        val sharePref = getSharedPreferences(
            "myPref", Context.MODE_PRIVATE
        ) //public (nooo), private, append (prendo delle pref esistenti e aggiundo mia roba)
        val editor = sharePref.edit()

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val isAdult = cbAdult.isChecked

            editor.apply() {
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply() //scrivi in moso asincrono
                //commit() fa la stessa cosa ma lo fa in modo sincrono, no noo
            }
        }

        btnLoad.setOnClickListener {
            val name = sharePref.getString("name", null) //secondo valore default
            val age = sharePref.getInt("age", 0)
            val isAdult = sharePref.getBoolean("isAdult", false)

            etName.setText(name)
            etAge.setText(age.toString())
            cbAdult.isChecked = isAdult
        }
    }
}