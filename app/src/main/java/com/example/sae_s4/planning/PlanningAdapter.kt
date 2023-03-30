package com.example.sae_s4.planning

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sae_s4.R

class PlanningAdapter(
    private val dataHeure: MutableList<String>,
    private val dataPlanning: MutableList<PlanningFragment.Evenement>,
    private val dateRef: String
) : RecyclerView.Adapter<PlanningAdapter.ItemPlanningViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPlanningViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_of_list_planning, parent, false)

        return ItemPlanningViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataHeure.size

    override fun onBindViewHolder(holder: ItemPlanningViewHolder, position: Int) {

        val heure = dataHeure[position]
        holder.heure.text = heure

        for (item in dataPlanning) {
            if (dateRef.equals(item.date)) {
                if (heure == item.debut) {
                    holder.background.setBackgroundResource(R.color.dark_blue.toInt())
                    holder.contenu.text = item.nom
                    return
                }
                if (heure >= item.debut && heure < item.fin) {
                    holder.background.setBackgroundResource(R.color.dark_blue.toInt())
                    holder.trait.visibility = View.INVISIBLE
                    return
                }
            }
        }
    }

    class ItemPlanningViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val background: ConstraintLayout = view.findViewById(R.id.id_background_case_planning)
        val contenu: TextView = view.findViewById(R.id.id_contenu_planning)
        val heure: TextView = view.findViewById(R.id.id_heure_planning)
        val trait: View = view.findViewById(R.id.id_trait_horizontal_planning)
    }
}
