package com.viaagra.airoptimizemyapplibproject

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.mumayank.airoptimizemyapplib.AirOptimizeMyAppActivity
import com.pixplicity.easyprefs.library.Prefs
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
                ).putExtra(
                    AirOptimizeMyAppActivity.IS_THEME_LIGHT,
                    Prefs.getBoolean(App.PREFS_IS_SELECTED_THEME_LIGHT, true)
                )
            )
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            rg.visibility = View.VISIBLE
        } else {
            rg.visibility = View.GONE
        }

        if (Prefs.getBoolean(App.PREFS_IS_SELECTED_THEME_LIGHT, true)) {
            rbLight.isChecked = true
            rbDark.isChecked = false
        } else {
            rbLight.isChecked = false
            rbDark.isChecked = true
        }

        rg.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbLight -> setTheme(true)
                R.id.rbDark -> setTheme(false)
            }
        }
    }

    private fun setTheme(isSelectedThemeLight: Boolean) {
        Prefs.putBoolean(App.PREFS_IS_SELECTED_THEME_LIGHT, isSelectedThemeLight)
        AppCompatDelegate.setDefaultNightMode(if (isSelectedThemeLight) AppCompatDelegate.MODE_NIGHT_NO else AppCompatDelegate.MODE_NIGHT_YES)
    }
}