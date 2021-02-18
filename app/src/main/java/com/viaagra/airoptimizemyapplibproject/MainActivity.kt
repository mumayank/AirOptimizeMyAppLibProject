package com.viaagra.airoptimizemyapplibproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mumayank.airoptimizemyapplib.AirOptimizeMyAppActivity
import kotlinx.android.synthetic.main.ao_main_activity.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ao_main_activity)

        optimizationButton.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    AirOptimizeMyAppActivity::class.java
                )
            )
        }
    }
}