package com.sabirhalil.calculatebmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sabirhalil.calculatebmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {

            if (binding.etKg.text.isEmpty() || binding.etHeight.text.isEmpty()){
                Toast.makeText(this,"you have to fill fields above", Toast.LENGTH_SHORT).show()
            }else{
                val weight = binding.etKg.text.toString().toDouble()
                val height = binding.etHeight.text.toString().toDouble() / 100

                val bmi = weight / (height * height)

                if (bmi < 18.5)
                    binding.tvResult.text = "you are underweight"
                else if(bmi > 24.9)
                    binding.tvResult.text = "you are overweight"
                else
                    binding.tvResult.text = "you are in healthy range"

            }
        }

    }
}