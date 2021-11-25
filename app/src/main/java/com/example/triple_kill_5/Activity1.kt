package com.example.triple_kill_5

import android.content.Intent
import android.os.Bundle
import com.example.triple_kill_5.databinding.Fragment1Binding


class Activity1 : Abstract() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Fragment1Binding.inflate(layoutInflater).apply {
            setContentView(root)
            navView.setNavigationItemSelectedListener(this@Activity1)
            bnToSecond.setOnClickListener {
                startActivity(Intent(this@Activity1, Activity2::class.java))
            }
        }
    }
}