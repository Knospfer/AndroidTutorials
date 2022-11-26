package com.mberrueta.a21_intent_service

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyIntentService
        var isRunning = false

        fun stopService() {
            Log.d("LOGGO", "Service is Stopping")
            isRunning = false
            instance.stopSelf()
        }
    }

    /**
     * Quando starto il servizio creo un intent
     * e gli posso passare dei dati
     *
     * questa funzione prende l'intent che passo al service quando lo starto
     *
     * ogni volta che lo starto gli passo un intent diverso (vengono inseriti in una coda
     * IntentWorkQue) e lui uno alla volta se li smazza
     *
     * Quando non ho più intent il service muore
     * **/
    override fun onHandleIntent(p0: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("LOGGO", "Service is running..")
                Thread.sleep(1000)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}