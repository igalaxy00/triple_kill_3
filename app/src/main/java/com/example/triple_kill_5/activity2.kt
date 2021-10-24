package com.example.triple_kill_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.triple_kill_5.databinding.Activity2Binding

class activity2 : AppCompatActivity() {
    companion object {
        private const val ONLY_REQUEST = 0;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToThird.setOnClickListener {
            goToThird()
        }

        binding.btnToFirst.setOnClickListener {
            finish()
        }

        binding.btnToAbout.setOnClickListener {
            goToAbout()
        }
    }

    private fun goToThird() {
        val intent = Intent(this, activity3::class.java)
        startActivity(intent)
    }

    private fun goToAbout() {
        val intent = Intent(this, activityAbout::class.java)
        startActivity(intent)
    }


}