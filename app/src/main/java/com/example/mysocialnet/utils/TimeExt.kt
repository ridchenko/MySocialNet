package com.example.mysocialnet.utils

import android.content.Context
import com.example.mysocialnet.R
import java.util.*

fun Date.getUserTimeString(context: Context): String {
    val resources = context.resources
    val millsAgo = System.currentTimeMillis() - time
    val minutesAgo = (millsAgo / 60000).toInt()
    return if (minutesAgo < 60) {
        if (minutesAgo < 1) resources.getString(R.string.moment_ago) else resources.getString(
            R.string.min_ago_post,
            minutesAgo
        )
    } else {
        val hoursAgo = (minutesAgo / 60)
        if (hoursAgo < 24) {
            resources.getString(R.string.hours_ago_post, hoursAgo)
        } else {
            val daysAgo = hoursAgo / 24
            if (daysAgo < 7) {
                resources.getQuantityString(R.plurals.days_ago, daysAgo, daysAgo)
            } else {
                val weeksAgo = daysAgo / 7
                if (weeksAgo < 4) {
                    resources.getQuantityString(R.plurals.week_ago, weeksAgo, weeksAgo)
                } else {
                    val monthAgo = daysAgo / 30
                    if (monthAgo < 12) {
                        resources.getQuantityString(R.plurals.month_ago, monthAgo, monthAgo)
                    } else {
                        val yearsAgo = monthAgo / 12
                        resources.getQuantityString(R.plurals.year_ago, yearsAgo, yearsAgo)                    }
                }
            }
        }
    }
}