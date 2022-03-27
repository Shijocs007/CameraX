package com.example.camerax

import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun getTimeString(): String {
        return SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS", Locale.US)
            .format(System.currentTimeMillis())
    }
}