package com.example.triple_kill_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.triple_kill_5.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityAboutBinding.inflate(layoutInflater).apply {
            setContentView(root)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            btnBack.setOnClickListener {
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}