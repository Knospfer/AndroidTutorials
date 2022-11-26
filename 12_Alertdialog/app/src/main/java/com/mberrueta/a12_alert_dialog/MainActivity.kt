package com.mberrueta.a12_alert_dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDialog1 = findViewById<Button>(R.id.btnDialog1)
        val btnDialog2 = findViewById<Button>(R.id.btnDialog2)
        val btnDialog3 = findViewById<Button>(R.id.btnDialog3)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add me to you contact list?")
            .setIcon(R.drawable.ic_action_name)
            .setPositiveButton("Yes") { _, _ -> //dialogInterface e numero del bottone cliccato
                Toast.makeText(this, "You added me to your contact list", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ -> //dialogInterface e numero del bottone cliccato
                Toast.makeText(
                    this,
                    "You DID NOT added me to your contact list",
                    Toast.LENGTH_SHORT
                ).show()
            }.create()

        btnDialog1.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf("Charmender", "Squirtle", "Bulbasaur")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one")
            .setSingleChoiceItems(options, 0) { _, i ->
                Toast.makeText(this, "You choosed ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes") { _, _ -> //dialogInterface e numero del bottone cliccato
                Toast.makeText(this, "You accepted choice", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ -> //dialogInterface e numero del bottone cliccato
                Toast.makeText(
                    this,
                    "You DECLINED choice",
                    Toast.LENGTH_SHORT
                ).show()
            }.create()

        btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                val action = if (isChecked) "checked" else "unchecked"
                Toast.makeText(this, "You $action ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes") { _, _ -> //dialogInterface e numero del bottone cliccato
                Toast.makeText(this, "You accepted choice", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ -> //dialogInterface e numero del bottone cliccato
                Toast.makeText(
                    this,
                    "You DECLINED choice",
                    Toast.LENGTH_SHORT
                ).show()
            }.create()

        btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}