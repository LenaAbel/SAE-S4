package com.example.sae_s4.prestataire

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sae.data.DataPrestataires
import com.example.sae.prestataire.DetailPrestaAdapter
import com.example.sae_s4.R

class DetailPrestaFragment : Fragment() {
    private lateinit var prestataire: Prestataire

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prestataire = DataPrestataires.restaurants[arguments?.getString("presta")?.toInt()!!]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_detail_presta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewNom: TextView = view.findViewById(R.id.id_page_presta_nom)
        textViewNom.text = prestataire.nom_prestataire

//        val imageView: ImageView = view.findViewById(R.id.id_page_presta_img)
//        imageView.setImageResource(prestataire.image_page)

        val textAProposView: TextView = view.findViewById(R.id.id_page_presta_text)
        textAProposView.text = prestataire.text_a_propos

        if (prestataire.commentaires.size == 0) {
            val pasCommentaireTextView: TextView = view.findViewById(R.id.id_pas_commentaire)
            pasCommentaireTextView.visibility = View.VISIBLE
        }
        else {
            val recyclerView: RecyclerView = view.findViewById(R.id.id_recyclerView_page_presta)
            recyclerView.adapter = DetailPrestaAdapter(prestataire.commentaires)
            recyclerView.setHasFixedSize(true)
        }
    }
}