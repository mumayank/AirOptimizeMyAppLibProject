package com.viaagra.airoptimizemyapplibproject

import android.app.Application
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatDelegate
import com.pixplicity.easyprefs.library.Prefs

class App : Application() {

    companion object {
        const val PREFS_IS_SELECTED_THEME_LIGHT = "PREFS_IS_SELECTED_THEME_LIGHT"
    }

    override fun onCreate() {
        super.onCreate()

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()

        if (Prefs.getBoolean(PREFS_IS_SELECTED_THEME_LIGHT, true)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}