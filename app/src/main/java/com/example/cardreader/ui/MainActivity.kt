package com.example.cardreader.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cardreader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.entbtn.setOnClickListener {
            var dialog = EnterCardDialog()
            dialog.show(supportFragmentManager,dialog.tag)

        }


    }
}