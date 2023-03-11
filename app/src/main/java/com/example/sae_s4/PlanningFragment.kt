package com.example.sae

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.sae_s4.R

class PlanningFragment() : Fragment() {

    private var jour: Int = 1

    private var heure: MutableList<String> = mutableListOf(
        "08:00",
        "08:30",
        "09:00",
        "09:30",
        "10:00",
        "10:30",
        "11:00",
        "11:30",
        "12:00",
        "12:30",
        "13:00",
        "13:30",
        "14:00",
        "14:30",
        "15:00",
        "15:30",
        "16:00",
        "16:30",
        "17:00",
        "17:30",
        "18:00",
        "18:30",
        "19:00",
        "19:30",
        "20:00"
    )

    private var planning: MutableList<Evenement> = mutableListOf(
        Evenement("Match d'escrime", heure.get(12), heure.get(15), "15.08.2023"),
        Evenement("Match de judo", heure.get(2), heure.get(6), "16.08.2023"),
        Evenement("Tournoi de tennis de table", heure.get(14), heure.get(16), "16.08.2023")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_planning, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.idRecyclerViewPlanning)
        recyclerView.adapter = PlanningAdapter(heure, planning, "15.08.2023")

        val btnChangeDay: Button = view.findViewById(R.id.id_changement_jour)
        btnChangeDay.setOnClickListener {
            if (jour == 1) {
                recyclerView.adapter = PlanningAdapter(heure, planning, "16.08.2023")
                (activity as AppCompatActivity).supportActionBar?.title =
                    getString(R.string.page_planning_jour_2)
                jour = 2
            }
            else {
                recyclerView.adapter = PlanningAdapter(heure, planning, "15.08.2023")
                (activity as AppCompatActivity).supportActionBar?.title =
                    getString(R.string.page_planning_jour_1)
                jour = 1
            }
        }
    }

    data class Evenement(
        val nom: String,
        val debut: String,
        val fin: String,
        val date: String
    )
}