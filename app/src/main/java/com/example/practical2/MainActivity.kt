package com.example.practical2

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextWeight:EditText = findViewById(R.id.editTextWeight)
        val editTextHeight:EditText = findViewById(R.id.editTextHeight)
        val buttonCalculate:Button = findViewById(R.id.buttonCalculate)
        val buttonReset:Button = findViewById(R.id.buttonReset)
        val textviewBMI:TextView = findViewById(R.id.textViewBMI)
        val imageViewBMI:ImageView = findViewById(R.id.imageViewBMI)

    buttonCalculate.setOnClickListener{
        val weight:Float = editTextWeight.text.toString().toFloat()
        val height:Float = editTextHeight.text.toString().toFloat()
        val bmi:Float = weight/(height/100).pow(2)
        textviewBMI.text = ("%.2f".format(bmi)).toString()

        //TO DO
        if(bmi<=18.5){
            //display underweight picture
           imageViewBMI.setImageResource(R.drawable.under)
        }
        else if(bmi <=24.9){
            //display normal
            imageViewBMI.setImageResource(R.drawable.normal)
        }
        else {
            //display overweight
            imageViewBMI.setImageResource(R.drawable.over)
        }
    }

    buttonReset.setOnClickListener{
        textviewBMI.text = "BMI"
        editTextWeight.text = null
        editTextHeight.text = null
        imageViewBMI.setImageResource(R.drawable.empty)

    }

    }
}