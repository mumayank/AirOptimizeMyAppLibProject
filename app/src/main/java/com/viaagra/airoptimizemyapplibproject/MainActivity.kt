package com.viaagra.airoptimizemyapplibproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mumayank.airoptimizemyapplib.AirOptimizeMyAppActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AirOptimizeMyAppActivity.startActivity(this)
    }
}