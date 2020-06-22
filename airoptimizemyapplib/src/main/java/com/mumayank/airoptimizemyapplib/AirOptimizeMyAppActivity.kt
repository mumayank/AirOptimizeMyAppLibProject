package com.mumayank.airoptimizemyapplib

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.air_optimize_my_app_activity.*

class AirOptimizeMyAppActivity : AppCompatActivity() {

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, AirOptimizeMyAppActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.air_optimize_my_app_activity)
        doneLayout.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        val toast = Toast.makeText(this, "Please tap on the confirmation to exit", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 300)
        toast.show()
    }
}