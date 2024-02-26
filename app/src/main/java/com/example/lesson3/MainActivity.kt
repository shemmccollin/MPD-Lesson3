package com.example.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mutableList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chemicalButton.setOnClickListener { _ ->
            if(binding.chemicalText.text.toString().isNullOrBlank())
            {
                binding.tv.text = "Chemical text can not be empty."
            }
            else if(mutableList.contains(binding.chemicalText.text.toString()))
            {
                binding.tv.text = "Chemical '${binding.chemicalText.text}' is already available.";
            }
            else
            {
                binding.tv.text = "Chemical '${binding.chemicalText.text}' added successfully.";
                mutableList.add(binding.chemicalText.text.toString())
                binding.chemicalText.text.clear()
            }
        }

        binding.guessButton.setOnClickListener{ _ ->
            if(mutableList.size == 0){
                binding.tv.text = "No chemicals in the list to guess from."
                return@setOnClickListener
            }

            var random = (0 until mutableList.size).random()

            if(binding.guessText.text.toString().isNullOrBlank()){
                binding.tv.text = "Guess text can not be empty."
            }
            else if(mutableList[random] == binding.guessText.text.toString()){
                binding.tv.text =  "Congratulations! You guessed it right. It was ${mutableList[random]}."
            }
            else{
                binding.tv.text =  "Sorry, wrong guess. The correct answer was ${mutableList[random]}."
            }
        }
    }
}