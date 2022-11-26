package com.mberrueta.a9_permissions

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRequestPermission = findViewById<Button>(R.id.btnRequestPermissions)

        btnRequestPermission.setOnClickListener {
            requestPermissions()
        }
    }

    private fun hasWriteExternalStoragePermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationForegroundPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    //Questa va fatta da android Q in poi, sennò crasha
    private fun hasLocationBackgroundPermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    private fun requestPermissions() {
        var permissionsToRequest = mutableListOf<String>()
        if (!hasWriteExternalStoragePermission()) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!hasLocationForegroundPermission()) {
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        //non posso più chiederli contemporaneamente da android 11, devo farlo 2 volte in 2 funzioni diverse
//        if (!hasLocationBackgroundPermission()) {
//            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
//        }
        if (permissionsToRequest.isNotEmpty()) {
            Log.d("LOGGO", permissionsToRequest.toTypedArray().toString())
            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
        }

        //così funziona solo se ritappo il bottone
        if (!hasLocationBackgroundPermission()) {
            permissionsToRequest.clear()
            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("LOGGO", "${permissions[i]} ganted")
                }
            }
        }
    }
}