package com.example.sae_s4


import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cn.iwgang.countdownview.CountdownView
import java.util.*
import kotlin.math.log


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_map)


        // Start the countdown
        countdownTimeCalculator()



    }

    /**
     * This function calculates the time left until the end date of the festival
     */
    private fun countdownTimeCalculator() {
        // Get the countdown view
        val myCountdownView = findViewById<View>(R.id.mycountdown) as CountdownView

        // Get the shared preferences
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this)

        // Get the saved end date or use default value (August 15th, 2023)
        val endDate = Calendar.getInstance()
        endDate.timeInMillis = sharedPrefs.getLong("end_date", getEndDate().timeInMillis)

        // Calculate the time left until the end date
        val now = Calendar.getInstance()
        Log.d("MainActivity", "Now: " + now.timeInMillis.toString())
        val timeInMillis = getEndDate().timeInMillis - now.timeInMillis - 3600000
        myCountdownView.start(timeInMillis)

        // Save the end date in the shared preferences
        with(sharedPrefs.edit()) {
            putLong("end_date", endDate.timeInMillis)
            apply()
        }
    }

    private fun getEndDate(): Calendar {
        val endDate = Calendar.getInstance()
        // Set the end date to August 15th, 2023 at 8 am
        endDate.set(2023, Calendar.AUGUST, 15, 8, 0, 0)
        Log.d("MainActivity", "End date: " + endDate.time.toString())
        return endDate
    }
}