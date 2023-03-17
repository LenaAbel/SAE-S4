package com.example.sae_s4.prestataires

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sae_s4.R

class RestaurantsFragment : Fragment() {

    val restaurants: MutableList<Prestataire> = mutableListOf(
        Prestataire(
            1,
            "Subway",
            "https://www.just-eat.fr/subway",
            R.drawable.img_resto_1
        ),
        Prestataire(
            2,
            "Le camion qui fume",
            "https://lecamionquifume.com",
            R.drawable.img_resto_2
        ),
        Prestataire(
            3,
            "Courtepaille",
            "https://www.courtepaille.com",
            R.drawable.img_resto_3
        ),
        Prestataire(
            4,
            "La Citadelle de Belfort",
            "https://www.belfort-tourisme.com/restaurant/cafe-restaurant-de-la-citadelle",
            R.drawable.img_resto_4
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.idRecyclerView)
        recyclerView.adapter = RestaurantsAdapter(restaurants, this)
        recyclerView.setHasFixedSize(true)
    }
}