package com.example.sae


import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.iwgang.countdownview.CountdownView
import java.util.*
import com.example.sae_s4.R

class AccueilFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_accueil, container, false)
        // Inflate the layout for this fragment
        return view
    }

    /**
     * This function calculates the time left until the end date of the festival
     */
    private fun countdownTimeCalculator() {
        // Get the countdown view
        val myCountdownView = view?.findViewById<View>(R.id.mycountdown) as? CountdownView

        if (myCountdownView != null) {
            // Get the shared preferences
            val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(activity)

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
        } else {
            Log.d("MainActivity", "myCountdownView is null")
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