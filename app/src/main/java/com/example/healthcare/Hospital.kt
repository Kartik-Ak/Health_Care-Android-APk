package com.example.healthcare

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.net.toUri

@SuppressLint("QueryPermissionsNeeded")
fun openNearbyHospitals(context: Context) {
    val gmmIntentUri = "geo:0,0?q=hospitals".toUri()
    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
    val chooser = Intent.createChooser(mapIntent, "Select Maps App")
    context.startActivity(chooser)

      try {
        context.startActivity(mapIntent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "Google Maps not found on your device.", Toast.LENGTH_LONG).show()
    }

}

fun EmrgencyCall(context: Context, phoneNumber: String) {
    val dialIntent = Intent(Intent.ACTION_DIAL)
    dialIntent.data = Uri.parse("tel:$phoneNumber")

    try {
        context.startActivity(dialIntent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "No app found to make call", Toast.LENGTH_SHORT).show()
    }
}

fun makePhoneCall(context: Context, phoneNumber: String) {
    val callIntent = Intent(Intent.ACTION_CALL)
    callIntent.data = Uri.parse("tel:$phoneNumber")

    try {
        ContextCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE).let {
            if (it == PackageManager.PERMISSION_GRANTED) {
                context.startActivity(callIntent)
            } else {
                Toast.makeText(context, "Call permission not granted", Toast.LENGTH_SHORT).show()
            }
        }
    } catch (e: SecurityException) {
        e.printStackTrace()
        Toast.makeText(context, "Security exception", Toast.LENGTH_SHORT).show()
    }
}



