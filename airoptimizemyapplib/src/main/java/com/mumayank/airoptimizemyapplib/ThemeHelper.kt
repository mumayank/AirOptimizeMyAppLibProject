package com.mumayank.airoptimizemyapplib

import androidx.appcompat.app.AppCompatDelegate

class ThemeHelper {
    companion object {
        fun setTheme(isLight: Boolean) {
            AppCompatDelegate.setDefaultNightMode(if (isLight) AppCompatDelegate.MODE_NIGHT_NO else AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}