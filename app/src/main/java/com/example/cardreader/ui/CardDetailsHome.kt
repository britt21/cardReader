package com.example.cardreader.ui

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.cardreader.data.card_info.response.CardInfoResponse
import com.example.cardreader.databinding.CardDetailsHomeBinding

class CardDetailsHome : AppCompatActivity(){
    lateinit var binding : CardDetailsHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CardDetailsHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var data = intent.getParcelableExtra<CardInfoResponse>("cardInfo")
        binding.etname.setText(data?.country!!.name)
        binding.etbrand.setText(data.brand)
        binding.ettype.setText(data.type)
        binding.etcountry.setText(data?.country!!.name)


    }
}