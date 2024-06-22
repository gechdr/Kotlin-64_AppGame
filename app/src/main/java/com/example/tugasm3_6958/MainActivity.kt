package com.example.tugasm3_6958

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugasm3_6958.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnStart.setOnClickListener {
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }

        binding.btnGuide.setOnClickListener {
            val intent = Intent(this, GuideActivity::class.java)
            startActivity(intent)
        }

        binding.btnFeedback.setOnClickListener {

            val alphaNumeric: List<Char> = ('A'..'Z') + ('0'..'9')

            var noRef: String

            var valid = false

            do {
                noRef = List(10) { alphaNumeric.random() }.joinToString("")

                valid = true

                if (!noRef.contains("[A-Z]".toRegex())) {
                    valid = false
                }

                if (!noRef.contains("[0-9]".toRegex())) {
                    valid = false
                }

            } while (!valid)

            val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
            val currentDate = sdf.format(Date())

            val subject = "FEEDBACK GAME 64\n" +
                    "No. Ref : $noRef\n" +
                    "Tgl/Jam : $currentDate\n" +
                    "Nama : \n" +
                    "Feedback : \n"

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:081998877665")
                putExtra("sms_body", subject)
            }
            startActivity(intent)
        }

    }
}