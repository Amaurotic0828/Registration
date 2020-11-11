package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

import org.w3c.dom.Text


class DateChooser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_chooser)

        findViewById<Button>(R.id.btnResult).setOnClickListener{gotoResultActivity()}

        val calendar = findViewById<CalendarView>(R.id.calendarView)
        val calendarValue = findViewById<TextView>(R.id.myDate)
        calendar.setDate(685604900000, false,true)
        calendar.setOnDateChangeListener { _, i, i2, i3 ->
            val month = "$i2"
            val cnvrtMonthtoInt = month.toInt()
            val addonetoMonth = cnvrtMonthtoInt+1
            calendarValue.text = ("$i3/$addonetoMonth/$i").toString()
        }

       val phoneNumbertext = findViewById<EditText>(R.id.editTextNumber)
            phoneNumbertext.setVisibility(View.INVISIBLE)
        val switch = findViewById<Switch>(R.id.switchView)
                switch.setOnClickListener{
            if(findViewById<Switch>(R.id.switchView).isChecked){
                phoneNumbertext.setVisibility(View.VISIBLE)
            }else{
                phoneNumbertext.setVisibility(View.INVISIBLE)
            }
        }


    }//end of onCreate



        private fun gotoResultActivity(){
            val birthday = findViewById<TextView>(R.id.myDate).text.toString()
            val phonenumber = findViewById<EditText>(R.id.editTextNumber).text.toString()
       val gotoResultIntent = Intent(this, displayResult::class.java)
            val firstname = intent.getStringExtra("fname")
            val lastname = intent.getStringExtra("lname")
            val emailadd = intent.getStringExtra("email")
            val edad = intent.getStringExtra("age")
            val result = "First Name:\t $firstname" +
                    "\nLast Name: \t $lastname" +
                    "\nEmail Address: \t $emailadd" +
                    "\nAge: \t $edad" +
                    "\nDate of Birth: \t $birthday" +
                    "\nPhone Number: \t $phonenumber"
            gotoResultIntent.putExtra("result", result)
        startActivity(gotoResultIntent)
    }//end of private fun

}//end of Class