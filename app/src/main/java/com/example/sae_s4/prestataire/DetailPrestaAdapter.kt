package com.example.sae.prestataire

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sae_s4.R
import com.example.sae_s4.prestataire.Commentaire

class DetailPrestaAdapter(
    private val commentaires: MutableList<Commentaire>
) : RecyclerView.Adapter<DetailPrestaAdapter.ItemCommentaireViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCommentaireViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_of_list_commentaires, parent, false)

        return DetailPrestaAdapter.ItemCommentaireViewHolder(adapterLayout)
    }

    override fun getItemCount() = commentaires.size

    override fun onBindViewHolder(holder: ItemCommentaireViewHolder, position: Int) {
        holder.nomAuteurtextView.text = commentaires[position].nom_auteur
        holder.libelleCommentaireTextView.text = commentaires[position].libelle_commentaire
        holder.libelleNoteTextView.text = commentaires[position].libelle_note
    }

    class ItemCommentaireViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomAuteurtextView: TextView = view.findViewById(R.id.id_commentaire_nom_auteur)
        val libelleCommentaireTextView: TextView = view.findViewById(R.id.id_libelle_commentaire)
        val libelleNoteTextView: TextView = view.findViewById(R.id.id_libelle_note)
    }
}