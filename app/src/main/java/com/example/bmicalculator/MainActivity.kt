package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateBmi()
        }

        buttonReset.setOnClickListener {
            resetOutput(buttonReset)
        }
    }

    private fun calculateBmi(){
        //TODO : Calculate BMI and show all output
        if(editTextHeight.text.isEmpty()){
            editTextHeight.setError(getString(R.string.error_input))
            return
        }

        if(editTextWeight.text.isEmpty()){
            editTextWeight.setError(getString(R.string.error_input))
            return
        }

        val weight : Float = editTextWeight.text.toString().toFloat()
        val height : Float = editTextHeight.text.toString().toFloat()

        val bmi_result = weight / height.pow(2)

        textViewBmi.text = String.format("%s %.2f", "BMI : ",bmi_result)

        if(bmi_result < 18.5) {
            imageViewProfileImage.setImageResource(R.drawable.under)
            textViewStatus.text = String.format("%s %s", "Status : ",getString(R.string.underweight))
        }
        else if(bmi_result >=18.5 && bmi_result < 25) {
            imageViewProfileImage.setImageResource(R.drawable.normal)
            textViewStatus.text = String.format("%s %s", "Status : ", getString(R.string.normal))
        }
        else {
            imageViewProfileImage.setImageResource(R.drawable.over)
            textViewStatus.text = String.format("%s %s", "Status : ",getString(R.string.overweight))
        }
    }

    fun resetOutput(view : View){
        //TODO : Clear all inputs and outputs
        editTextWeight.text.clear()
        editTextHeight.text.clear()
        imageViewProfileImage.setImageResource(R.drawable.empty)
        textViewBmi.text = getString(R.string.bmi)
        textViewStatus.text = getString(R.string.status)
    }
}
