package com.mberrueta.a22_services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * Lui supporta multithreading MA parte sul main thread di default male male
 * **/
class MyService : Service() {
    val TAG = "LOGGO: MyService"

    init {
        Log.d(
            TAG,
            "Service is running.."
        ) //dubbio ma se ne creo tanti come faccio a vedere chi è vivo?
    }

    /**
     * Serve per far parlare molti client che accendo al service contemporaneamente
     * **/
    override fun onBind(p0: Intent?): IBinder? = null //questo significa RITORNA NULL

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //posso prendermi l'intent che ha startato il service e farci cose

        val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {  //questa cosa è in if Let di swift!!
            Log.d(TAG, dataString)
        }

//        return super.onStartCommand(intent, flags, startId) //DEFAULT

        /**
         * di base un service va all'infinito finchè non lo stoppo io
         * ma android lo ammazza se ha bisogno di risorse
         *
         * in base a cosa ritorno decido come viene gestito dal os
         * se android mi ammazza il service
         * **/

        //return types
//        START_NOT_STICKY //se ammazzato, non lo ricrea
//        START_STICKY //se lo ammazza, lo ricrea se possibile e gli passa un null intent
//        START_REDELIVER_INTENT //se lo ammazza, lo ricrea e gli passa l'ultimo intent

        Thread {
            //faccio cose in un thread separato
        }.start()

        return START_STICKY
    }

    override fun onDestroy() {
        Log.d(TAG, "nooo sto morendoooo")
        super.onDestroy()
    }
}