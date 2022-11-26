package com.mberrueta.a10_implicit_intents

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTakePhoto = findViewById<Button>(R.id.btnTakePhoto)

        btnTakePhoto.setOnClickListener {
            //qui io aprirei un intent esplicito ma io non so prendere immagini
            //quindi faccio implicito

            //questo non va non so perchè
//            Intent(Intent.ACTION_GET_CONTENT).also {
//                //content può esserere qualsiasi cosa (media e cose così)
//                it.type === "image/*" //MIME TYPE TUTTE IMMAGINI
//
//                try {
//                    startActivityForResult(
//                        it,
//                        0
//                    ) //request code è sempre quella zozzeria per distinguere diverse richieste
//                } catch (e: ActivityNotFoundException) {
//                    Toast.makeText(this, "Non trovo intent", Toast.LENGTH_SHORT).show()
//                }
//
//
//            }

            //questo va, non so perchè
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, 0)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            val uri = data?.data
            val ivPhoto = findViewById<ImageView>(R.id.ivPhoto)
            ivPhoto.setImageURI(uri)
        }
    }
}

//quelli che facevamo prima era esplicito e funzinava solo per la nostra app e le nostre classi

//quelli impliciti non decivi che app deve fare l'azione (foto e cose così)