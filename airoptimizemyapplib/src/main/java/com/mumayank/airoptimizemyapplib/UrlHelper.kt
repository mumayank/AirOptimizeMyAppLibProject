package com.mumayank.airoptimizemyapplib

import android.app.Activity
import android.content.Intent
import android.net.Uri

class UrlHelper {
    companion object {

        fun openUrlInBrowser(activity: Activity, urlString: String) {
            activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(urlString)))
        }

    }
}