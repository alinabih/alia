package com.example.batarey

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.batarey.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.PersonAge
import kotlinx.android.synthetic.main.activity_main.PersonID
import kotlinx.android.synthetic.main.activity_main.PersonName
import kotlinx.android.synthetic.main.activity_main.submit

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    val myReceiver = MyReceiver()
    var intentFilter = IntentFilter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                 intentFilter = IntentFilter()
                intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED )
                intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
                intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
                intentFilter.addAction(Intent.ACTION_BOOT_COMPLETED)

                registerReceiver(myReceiver, intentFilter)
            }
        //submit to firebase
        submit.setOnClickListener{
            var name = PersonName.text.toString()
            var id = PersonID.text.toString()
            var age = PersonAge.text.toString()

            val person = hashMapOf(
                "name" to name,
                "id" to id,
                "age" to age
            )

            db.collection("Person")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(applicationContext, "${documentReference.id}", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext, "$e", Toast.LENGTH_LONG).show()
                }
        }
        }

        override fun onDestroy() {
            super.onDestroy()
          
            unregisterReceiver(myReceiver);
        }
    }
