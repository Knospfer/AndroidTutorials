package com.mberrueta.a24_broadcast_receivers

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var receiver: AirplaneModeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = AirplaneModeChangeReceiver()

        //registro il receiver DYNAMIC
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
            /**
             * se non metto l'onStop creo un memory leak:
             * gli passo il context della main activity
             * però il receiver vive anche dopo la chiusura dell'app
             * e tengo il context nel limbo
             *
             */
        }
    }

    //fix memory leak
    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}

/**
 * BROADCAST RECEIVERS
 *
 * ascolto eventi del telefono: quando parte, arrivano sms o chiamate
 *
 * per rispondere a questi eventi broadcast uso un receiver
 *
 * ESITONO 2 TIPI: STATIC (dichiarato nel manifest) e DINAMIC
 *
 * da android 6 (api 24) si usano solo quelli DYNAMIC
 *
 * (approfondire le differenze e se static è deprecato)
 *
 * **/