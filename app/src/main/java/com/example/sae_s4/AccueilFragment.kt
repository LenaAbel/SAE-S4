package com.example.sae


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import cn.iwgang.countdownview.CountdownView
import java.util.*
import com.example.sae_s4.R
import com.example.sae_s4.ViewPagerAdapter

class AccueilFragment : Fragment() {

    // On below line we are creating variable for view pager, viewpager adapter and the image list.
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>

    private var currentPage = 0
    private val DELAY_MS: Long = 2000 // Delay in milliseconds before sliding to the next item
    private val PERIOD_MS: Long = 3000 // Time interval between each slide

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_accueil, container, false)
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initializing variables of below line with their id.
        viewPager = view.findViewById(R.id.idViewPager)



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
        viewPagerAdapter = ViewPagerAdapter(this.context, imageList)

        // On below line we are setting adapter to our view pager.
        viewPager.adapter = viewPagerAdapter

        if (savedInstanceState != null) {
            viewPager.currentItem = savedInstanceState.getInt("current_page")
        }
        // Call the slideShow() method to start the automatic sliding
        slideShow()
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

    override fun onPause() {
        super.onPause()
        countdownTimeCalculator()
    }

    override fun onResume() {
        super.onResume()
        countdownTimeCalculator()
    }

    override fun onStart() {
        super.onStart()
        countdownTimeCalculator()
    }

    override fun onDestroy() {
        super.onDestroy()
        countdownTimeCalculator()
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