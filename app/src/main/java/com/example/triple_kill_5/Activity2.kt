package com.example.triple_kill_5

import android.content.Intent
import android.os.Bundle
import com.example.triple_kill_5.databinding.Fragment2Binding

class Activity2 : Abstract() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Fragment2Binding.inflate(layoutInflater).apply {
            setContentView(root)
            navView.setNavigationItemSelectedListener(this@Activity2)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            bnToFirst.setOnClickListener {
                finish()
            }
            bnToThird.setOnClickListener {
                startActivity(Intent(this@Activity2, Activity3::class.java))
            }
        }
    }
}