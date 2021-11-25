package com.example.triple_kill_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.triple_kill_5.databinding.Fragment3Binding

class Activity3  : Abstract() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Fragment3Binding.inflate(layoutInflater).apply {
            setContentView(root)
            navView.setNavigationItemSelectedListener(this@Activity3)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            bnToFirst.setOnClickListener {
                Intent(this@Activity3, Activity1::class.java).apply {
                    this.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(this)
                }
            }
            bnToSecond.setOnClickListener {
                finish()
            }
        }
    }
}