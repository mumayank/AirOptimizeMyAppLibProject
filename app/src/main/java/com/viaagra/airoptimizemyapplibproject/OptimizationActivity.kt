package com.viaagra.airoptimizemyapplibproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mumayank.airoptimizemyapplib.AirOptimizeMyAppActivity

class OptimizationActivity : AppCompatActivity() {

    companion object {
        private const val REQ_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.optimization_activity)
        startActivityForResult(Intent(this, AirOptimizeMyAppActivity::class.java), REQ_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_CODE) {
            finish()
        }
    }
}