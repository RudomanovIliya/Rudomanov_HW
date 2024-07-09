package com.example.profsofthw

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.profsofthw.SecondActivity.Companion.createStartIntent
import com.example.profsofthw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonToSecond.setOnClickListener {
            val stringHello = binding.textViewHello.text.toString()
            val intent = Intent(createStartIntent(this, stringHello))
            startActivity(intent)
        }
    }
}