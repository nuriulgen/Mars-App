package com.nuriulgen.marsapp.presentation.onboard.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.databinding.DataBindingUtil
import com.nuriulgen.marsapp.presentation.home.view.HomeActivity
import com.nuriulgen.marsapp.R
import com.nuriulgen.marsapp.databinding.ActivityMainBinding

class OnBoardActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.textView.text = Html.fromHtml(getString(R.string.on_board_title))

        binding.button2.setOnClickListener {
          val intent = Intent(this, HomeActivity :: class.java)
          startActivity(intent)
        }

    }
}