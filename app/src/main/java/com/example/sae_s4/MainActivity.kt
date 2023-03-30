package com.example.sae_s4

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.viewpager.widget.ViewPager
import cn.iwgang.countdownview.CountdownView
import com.example.sae_s4.databinding.ActivityMainBinding
import java.util.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    // On below line we are creating variable for view pager, viewpager adapter and the image list.
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>

    private var currentPage = 0
    private val DELAY_MS: Long = 2000 // Delay in milliseconds before sliding to the next item
    private val PERIOD_MS: Long = 3000 // Time interval between each slide
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        // Get the drawer layout
        drawerLayout = binding.drawerLayout

        // Get the view pager
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupWithNavController(binding.menuView, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        // initializing variables of below line with their id.
        viewPager = findViewById(R.id.idViewPager)



        // on below line we are initializing
        // our image list and adding data to it.
        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.adidas
        imageList = imageList + R.drawable.arena
        imageList = imageList + R.drawable.columbia
        imageList = imageList + R.drawable.decathlon
        imageList = imageList + R.drawable.gosport
        imageList = imageList + R.drawable.intersport
        imageList = imageList + R.drawable.irun
        imageList = imageList + R.drawable.nike
        imageList = imageList + R.drawable.puma
        imageList = imageList + R.drawable.salomon
        imageList = imageList + R.drawable.scott
        imageList = imageList + R.drawable.thenorthface
        imageList = imageList + R.drawable.tourdefrance
        imageList = imageList + R.drawable.vittel

        // On below line we are initializing our view pager adapter and adding image list to it.
        viewPagerAdapter = ViewPagerAdapter(this@MainActivity, imageList)

        // On below line we are setting adapter to our view pager.
        viewPager.adapter = viewPagerAdapter

        if (savedInstanceState != null) {
            viewPager.currentItem = savedInstanceState.getInt("current_page")
        }

        // Call the slideShow() method to start the automatic sliding
        slideShow()


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }


    override fun onPause() {
        super.onPause()
        countdownTimeCalculator()
        // Récupérer la position actuelle du slide et la stocker dans les préférences partagées
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = prefs.edit()
        editor.putInt("current_slide_position", viewPager.currentItem)
        editor.apply()
    }

    override fun onResume() {
        super.onResume()
        countdownTimeCalculator()
        // Récupérer la dernière position du slide à partir des préférences partagées et la définir sur le slide
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val position = prefs.getInt("current_slide_position", 0)
        viewPager.setCurrentItem(position, false)
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

    /**
     * This function returns the end date of the festival
     */
    private fun getEndDate(): Calendar {
        val endDate = Calendar.getInstance()
        // Set the end date to August 15th, 2023 at 8 am
        endDate.set(2023, Calendar.AUGUST, 15, 8, 0, 0)
        Log.d("MainActivity", "End date: " + endDate.time.toString())
        return endDate
    }

    /**
     * This function is used to start the automatic sliding of the images
     */
    private fun slideShow() {
        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            if (currentPage == imageList.size) {
                currentPage = 0
            }
            viewPager.setCurrentItem(currentPage++, true)
        }

        // Use the postDelayed() method of the Handler class
        // to start the slide show after the specified delay
        handler.postDelayed(runnable, DELAY_MS)
        handler.postDelayed({ slideShow() }, PERIOD_MS)
    }
}
