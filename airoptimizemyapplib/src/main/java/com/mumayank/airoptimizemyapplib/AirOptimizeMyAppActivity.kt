package com.mumayank.airoptimizemyapplib

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class AirOptimizeMyAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.air_optimize_my_app_activity)
        supportActionBar?.hide()

        findViewById<View>(R.id.instructions).setOnClickListener {
            UrlHelper.openUrlInBrowser(this, "https://dontkillmyapp.com/")
        }

        findViewById<View>(R.id.back).setOnClickListener {
            finish()
        }
    }

}