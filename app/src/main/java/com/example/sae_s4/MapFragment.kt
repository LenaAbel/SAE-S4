package com.example.sae_s4

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView


class MapFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_map, container, false)
        // Inflate the layout for this fragment
       val rg = view.findViewById<RadioGroup>(R.id.type_presta)
        rg.setOnCheckedChangeListener(onCheckedChangeListener)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private val onCheckedChangeListener = RadioGroup.OnCheckedChangeListener { group, checkedId ->
        when (checkedId) {
            R.id.resto -> {
                //Boucler sur toutes les imageView
                    // Penser à repasser toute les image à visible
                    // if correspond à resto
                        //puis les passer en invisble

//                val tabIdImageViewResto = intArrayOf(0,3,6,9,12,11)

                for (i in 2..23) {
//                for( i in tabIdImageViewResto){

                    val logo = view?.findViewById<ImageView>(R.id.logo+i)
                    logo?.setVisibility(ImageView.INVISIBLE)
                    Log.i("test", "azertyuiop")
                    Log.i("test", (R.id.logo+i).toString())
                    Log.i("test", i.toString())

//                    val logo = view?.findViewWithTag<ImageView>()


//                    if(logo?.getTag() == "@drawable/resto_logo"){
//                        Log.i("test", "qsdfghjklm")
    //                        Log.i("test", () logo?.getTag())

//                    logo?.setVisibility(ImageView.INVISIBLE)


//                    Log.i("logo", logo.toString())
//                    Log.i("test2", logo?.contentDescription.toString())
//                    if(logo?.tag.toString() == "1"){
//                        logo?.setVisibility(ImageView.INVISIBLE)
//                        Log.i("test", "azertyuiop")
//                    }else{
//                        Log.i("test", "qsdfghjklm")
////                        Log.i("test", () logo?.getTag())
//                        Log.i("test", logo?.tag.toString())
//                    }


                }

                //ceontent description
//                var logo = view?.findViewById<ImageView>(R.id.logo)
//                logo?.setImageResource(R.drawable.baseline_restaurant_24)
//                logo?.setVisibility(ImageView.INVISIBLE)

                //https://stackoverflow.com/questions/26370993/how-to-get-image-resource


//
            }
            R.id.club -> {
                // Write your code here
                Log.i("test", "poiuytreza")
            }
            R.id.magasin -> {
                // Write your code here
                Log.i("test", "wxcvbn")
            }
        }
    }

}