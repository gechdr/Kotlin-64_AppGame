package com.example.tugasm3_6958

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasm3_6958.databinding.ActivityGuideBinding

class GuideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        binding = ActivityGuideBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnBackGuide.setOnClickListener {
            finish()
        }
    }
}