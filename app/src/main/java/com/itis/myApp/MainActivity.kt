package com.itis.myApp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername : EditText
    private lateinit var etHeight : EditText
    private lateinit var etWeight : EditText
    private lateinit var etAge : EditText
    private lateinit var btnValidate : MaterialButton
    private lateinit var resultInfo : TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialisationFunc()

        btnValidate.setOnClickListener {

            val username = etUsername.text.toString().trim()
            val height = etHeight.text.toString().trim()
            val weight = etWeight.text.toString().trim()
            val age = etAge.text.toString().trim()

            if (username.isEmpty() || username.length > 50) {
                etUsername.error = getString(R.string.invalid_name)
                return@setOnClickListener
            } else if (height.isEmpty() || height.toInt() > 250) {
                etHeight.error = getString(R.string.invalid_height)
                return@setOnClickListener
            } else if (weight.isEmpty() || weight.toDouble() > 250.0) {
                etWeight.error = getString(R.string.invalid_weight)
                return@setOnClickListener
            } else if (age.isEmpty() || age.toInt() > 150) {
                etAge.error = getString(R.string.invalid_age)
                return@setOnClickListener
            } else {
                resultInfo.text = getAnswerString(username, height, weight, age)
                Toast.makeText(this, R.string.validation, Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun getAnswerString(username: String, height: String, weight: String, age: String): String {
        val callories : Int = ((88.36 + (13.4 + weight.toDouble()) + (4.8 * height.toDouble()) - (5.7 * age.toDouble()))*3).toInt()
        val nds : Int = username.length * 50 / 100
        val monthlyPayment : Int = ((height.toDouble() + weight.toDouble()) * 10).toInt()
        val horoscope : String = if (age.toInt() < 20)
            getString(R.string.horoscope_answer_1) else getString(R.string.horoscope_answer_2)
        val personalTax : Int = ((height.toDouble() * 100 + username.length * 10) * 5).toInt()
        val result: String = getString(R.string.result1) + callories + "\n" +
                getString(R.string.result2) + nds + "%\n" +
                getString(R.string.result3) + monthlyPayment + "\n" +
                getString(R.string.result4) + horoscope + "\n" +
                getString(R.string.result5) + personalTax
        return result
    }

    private fun initialisationFunc() {
        etUsername = findViewById(R.id.etUsername)
        etHeight = findViewById(R.id.etHeight)
        etWeight = findViewById(R.id.etWeight)
        etAge = findViewById(R.id.etAge)
        btnValidate = findViewById(R.id.btnValidate)
        resultInfo = findViewById(R.id.resultInfo)
    }
}