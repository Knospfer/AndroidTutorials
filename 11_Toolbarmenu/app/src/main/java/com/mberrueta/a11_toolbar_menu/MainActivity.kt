package com.mberrueta.a11_toolbar_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miAddContact -> Toast.makeText(this, "miAddContact", Toast.LENGTH_SHORT).show()
            R.id.miClose -> Toast.makeText(this, "miClose", Toast.LENGTH_SHORT).show()
            R.id.miFavourites -> Toast.makeText(this, "miFavourites", Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this, "miSettings", Toast.LENGTH_SHORT).show()
            R.id.miFeedback -> Toast.makeText(this, "miFeedback", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}