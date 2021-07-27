package com.example.calculatingschoolaverages

import android.graphics.Color
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate = btn_calculate
        val result = view_Results

        btnCalculate.setOnClickListener {
            val nameStudent = in_nameStudent.text.toString()
            val note1 = Integer.parseInt(in_note1.text.toString())
            val note2 = Integer.parseInt(in_note2.text.toString())
            val faults = Integer.parseInt(in_faults.text.toString())
            val average = (note1 + note2)/2

            if (average >= 6 && faults <= 10){
                result.setText("Aluno (a) " + nameStudent + "\n" + "Aprovado!!!" + "\n" + "Nota final: " + average + "\n" + "Faltas: " + faults)
                result.setTextColor(Color.GREEN)
            }else {
                result.setText("Aluno (a) " + nameStudent + "\n" + "Reprovado!!!" + "\n" + "Nota final: " + average + "\n" + "Faltas: " + faults)
                result.setTextColor(Color.RED)
            }
        }
    }
}