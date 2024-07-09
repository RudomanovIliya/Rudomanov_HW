package com.example.profsofthw

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.profsofthw.databinding.ActivitySecondBinding



class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(LayoutInflater.from(this)) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonNotification.setOnClickListener {
            Toast.makeText(this, intent?.getStringExtra(KEY_HELLO), Toast.LENGTH_SHORT).show()
        }
    }
    companion object {
        private const val KEY_HELLO = "key_hello"

        fun createStartIntent(context: Context, value: String): Intent {
            return Intent(context, SecondActivity::class.java).apply {
                putExtra(KEY_HELLO, value)
            }
        }
    }
}