package com.ranzan.and_03unit_41evaluation_i

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addDataBtn.setOnClickListener {
            val intent = Intent(MainActivity@ this, AddDataActivity::class.java)
            startActivity(intent)
        }
    }
}