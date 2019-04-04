package com.example.starterapp

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
        var countString:String
        var countint: Int
        //Toast.makeText(this,showCountTextView.text.toString(),Toast.LENGTH_LONG).show()

        try {
            countString = showCountTextView.text.toString()
            countint = Integer.parseInt(countString)
        } catch(e: Exception) {
            countString = "0"
            countint = 0
        }

        // Convert value to a number and increment it

        countint++

        // Display the new value in the text view.
        showCountTextView.text = countint.toString()
    }
}
