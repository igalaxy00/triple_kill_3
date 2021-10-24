package com.example.triple_kill_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.triple_kill_5.databinding.Activity1Binding


class activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToSecond.setOnClickListener {
            goToSecond()
        }
        binding.btnToAbout.setOnClickListener {
            goToAbout()
        }
    }

    private fun goToSecond() {
        val intent = Intent(this, activity2::class.java)
        startActivity(intent)
    }

    private fun goToAbout() {
        val intent = Intent(this, activityAbout::class.java)
        startActivity(intent)
    }
}