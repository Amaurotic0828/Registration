package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.nextView).setOnClickListener{gotoNextActivity()}

        val slider = findViewById<SeekBar>(R.id.seekBarView)
        val value = findViewById<TextView>(R.id.progressView)

        slider.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                    value.text = progress.toString()
            }//end of onProgressChanged
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }//end of onStartTrackingTouch
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }//end of onStopTrackingTouch
        })//end of setOnSeekBarChangeListener
    }//end of onCreate
    private fun gotoNextActivity (){
        val gotoNextIntent = Intent(this, DateChooser::class.java)
        val fname = findViewById<EditText>(R.id.fnView).text.toString()
        val lname = findViewById<EditText>(R.id.lnView).text.toString()
        val email = findViewById<EditText>(R.id.emailView).text.toString()
        val age = findViewById<TextView>(R.id.progressView).text.toString()
        gotoNextIntent.putExtra("fname", fname)
        gotoNextIntent.putExtra("lname", lname)
        gotoNextIntent.putExtra("email", email)
        gotoNextIntent.putExtra("age", age)
        startActivity(gotoNextIntent)
    }//end of gotoNextActivity

}//end of class