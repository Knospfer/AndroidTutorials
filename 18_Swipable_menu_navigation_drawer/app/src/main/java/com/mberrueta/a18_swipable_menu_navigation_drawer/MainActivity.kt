package com.mberrueta.a18_swipable_menu_navigation_drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.open,
            R.string.close
        ) //servono le label per le persone cieche
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState() //diciamo al toggle che può essere usato

        supportActionBar?.setDisplayHomeAsUpEnabled(true) //pusho il menu sullo stack di navigazione

        val navView = findViewById<NavigationView>(R.id.navView)
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miItem1 -> Toast.makeText(applicationContext, "Item 1", Toast.LENGTH_SHORT)
                    .show()
                R.id.miItem2 -> Toast.makeText(applicationContext, "Item 2", Toast.LENGTH_SHORT)
                    .show()
                R.id.miItem3 -> Toast.makeText(applicationContext, "Item 3", Toast.LENGTH_SHORT)
                    .show()
            }
            true //ho gestito il click
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true //se non metto questa condizione non va il bottone del menu
        return super.onOptionsItemSelected(item)
    }
}