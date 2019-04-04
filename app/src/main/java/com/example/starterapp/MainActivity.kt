package com.example.starterapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe (view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, findViewById<TextView>(R.id.textView).text.toString(), Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe (view: View) {
        // Get the text view
        val showCountTextView = findViewById<TextView>(R.id.textView)
        // Get the value of the text view.
        var countString:String = showCountTextView.text.toString()
        var countint: Int
        //Toast.makeText(this,showCountTextView.text.toString(),Toast.LENGTH_LONG).show()

        try {
            countint = Integer.parseInt(countString)
        } catch(e: Exception) {
            countint = 0
        }

        countint++

        // Display the new value in the text view.
        showCountTextView.text = countint.toString()
    }

    fun randomMe (view: View) {
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SecondActivity::class.java)

        // Get the current value of the text view.
        val countString = findViewById<TextView>(R.id.textView).text.toString()

        // Convert the count to an int
        var count: Int
        try {
            count = Integer.parseInt(countString)
        } catch(e: Exception) {
            count = 0
        }

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)

        // Start the new activity.
        startActivity(randomIntent)
    }
}
