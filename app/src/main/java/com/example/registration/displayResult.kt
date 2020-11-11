package com.example.registration

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class displayResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_result2)



        val btnGenerate = findViewById<Button>(R.id.changeView).setOnClickListener{change()}
        val logo = resources.obtainTypedArray(R.array.logo)



        val txt = findViewById<TextView>(R.id.resultView)
        val intent = getIntent()
        val output = intent.getStringExtra("result")
        txt.text = output
    }//end of onCreate

    private fun change(){

        val rand = Random()
        val randomNumber: Int = rand.nextInt(4)
        val iv = findViewById<ImageView>(R.id.imageView)
        iv.setBackgroundResource(resources.obtainTypedArray(R.array.logo).getResourceId(randomNumber, 1))
    }

}//end of class