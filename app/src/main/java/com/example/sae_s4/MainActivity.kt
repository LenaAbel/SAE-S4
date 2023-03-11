package com.example.sae_s4

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import cn.iwgang.countdownview.CountdownView
import com.example.sae_s4.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupWithNavController(binding.menuView, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    override fun onResume() {
        super.onResume()

        // Start the counter
        countdownTimeCalculator()
    }

    /**
     * This function calculates the time left until the end date of the festival
     */
    private fun countdownTimeCalculator() {
        // Get the countdown view
        val myCountdownView = findViewById<View>(R.id.mycountdown) as? CountdownView

        if (myCountdownView != null) {
            // Get the shared preferences
            val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this)

            // Get the saved end date or use default value (August 15th, 2023)
            val endDate = Calendar.getInstance()
            endDate.timeInMillis = sharedPrefs.getLong("end_date", getEndDate().timeInMillis)

            // Calculate the time left until the end date
            val now = Calendar.getInstance()
            Log.d("MainActivity", "Now: " + now.timeInMillis.toString())
            val timeInMillis = getEndDate().timeInMillis - now.timeInMillis - 7200000
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
