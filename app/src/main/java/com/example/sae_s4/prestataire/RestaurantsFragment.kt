package com.example.sae_s4.prestataire

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sae.data.DataPrestataires
import com.example.sae_s4.R

class RestaurantsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_prestataires, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.idRecyclerView)
        recyclerView.adapter = PrestatairesAdapter("resto", DataPrestataires.restaurants, this)
        recyclerView.setHasFixedSize(true)
    }
}