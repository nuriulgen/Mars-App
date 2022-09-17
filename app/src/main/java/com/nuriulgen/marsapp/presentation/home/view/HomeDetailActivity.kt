package com.nuriulgen.marsapp.presentation.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nuriulgen.marsapp.R
import com.nuriulgen.marsapp.databinding.ActivityHomeDetailBinding


class HomeDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_home_detail)

    binding.backButton.setOnClickListener {
        finish() // return to previous page function
    }

    val myIntent = intent
    val type = myIntent.getStringExtra("type")
    binding.type.text = type


    }
}