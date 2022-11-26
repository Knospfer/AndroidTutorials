package com.mberrueta.a24_broadcast_receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) { //android usa intent per comunicare
        val isAirplaneModeEnabled =
            intent?.getBooleanExtra("state", false) ?: return // è ?? più potente

        val message =
            if (isAirplaneModeEnabled) "AIRPLANE MODE ENABLEEEED"
            else "AIRPLANE MODE DISABLEEED"

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}