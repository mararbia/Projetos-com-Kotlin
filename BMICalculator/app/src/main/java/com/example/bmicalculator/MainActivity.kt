package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class MainActivity : AppCompatActivity() {

    lateinit var btn_questionMark: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

        btn_questionMark = findViewById(R.id.btn_questionMark)

        btn_questionMark.setOnClickListener {
            openResultActivity()
        }

    }

    private fun openResultActivity(){
        val intent = Intent(this, ResultActivity::class.java)
        startActivity(intent)
    }

    private fun setListeners(){
        edTxt_height?.doAfterTextChanged { text ->
            //Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        edTxt_weight.doOnTextChanged { text, _, _, _ ->
            //txt_Title?.text = text
        }

        btnCalculate?.setOnClickListener {
            BMICalculator(edTxt_weight.text.toString(), edTxt_height.text.toString())
        }



    }

    private fun BMICalculator(weight: String, height: String){
        val weight = weight.toFloatOrNull()
        val height = height.toFloatOrNull()

        if(weight != null && height != null) {
            val bmi = weight / (height * height)

            if(bmi < 18.5){
                txt_Title.text = "Seu IMC é \n %.2f \n (Abaixo do Peso)".format(bmi)
            } else if (bmi >= 18.5 && bmi <=24.9){
                txt_Title.text = "Seu IMC é \n %.2f \n (Peso normal)".format(bmi)
            } else if (bmi >= 25.0 && bmi <= 29.9){
                txt_Title.text = "Seu IMC é \n %.2f \n (Sobrepeso)".format(bmi)
            } else if (bmi >= 30.0 && bmi <= 34.9){
                txt_Title.text = "Seu IMC é \n %.2f \n (Obesidade - Grau I)".format(bmi)
            } else if (bmi >= 35.0 && bmi <= 39.9){
                txt_Title.text = "Seu IMC é \n %.2f \n (Obesidade Severa - Grau II)".format(bmi)
            } else if (bmi >= 40.0){
                txt_Title.text = "Seu IMC é \n %.2f \n (Obesidade Mórbida - Grau III)".format(bmi)
            }

        }

    }
}