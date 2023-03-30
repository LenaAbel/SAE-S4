package com.example.sae_s4.prestataire

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sae.data.DataPrestataires
import com.example.sae.prestataire.DetailPrestaAdapter
import com.example.sae_s4.R
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.ui.NavigationUI


class DetailPrestaFragment : Fragment() {
    private lateinit var prestataire: Prestataire

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true) // enable the Up button

        if (savedInstanceState != null) {
            val prestataireName = savedInstanceState.getString("prestataire_name")
            if (prestataireName != null) {
                val textViewPrestataireName = view?.findViewById<TextView>(R.id.id_page_presta_nom)
                textViewPrestataireName?.text = prestataireName
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detail_presta, container, false)

        // Get the presta_name argument from the bundle
        val prestaName = arguments?.getString("presta_name")

        // Set the presta name in the TextView
        view.findViewById<TextView>(R.id.id_page_presta_nom)?.text = prestaName

        return view // Replace the second inflater.inflate with 'view'
    }

    @SuppressLint("CutPasteId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Retrieve the tag name passed from MapFragment
        val prestaName = arguments?.getString("presta_name")

        // Check if prestaName is not null before updating the TextView
        if (prestaName != null) {
            view.findViewById<TextView>(R.id.id_page_presta_nom).text = prestaName
        }

        // Check if prestaName is not null before updating the TextView
        if (prestaName != null) {
            Log.d("DetailPrestaFragment", "Presta name: $prestaName")
            view.findViewById<TextView>(R.id.id_page_presta_nom).text = prestaName
        } else {
            Log.e("DetailPrestaFragment", "Presta name not found")
        }

        val type_prestataire = requireArguments().getString("quel_type_presta")
        val prestaIndex = requireArguments().getInt("presta")

        if (type_prestataire == "club")
            prestataire = DataPrestataires.clubs[prestaIndex]
        else
            prestataire = DataPrestataires.restaurants[prestaIndex]


        val textViewNom: TextView = view.findViewById(R.id.id_page_presta_nom)
        textViewNom.text = prestataire.nom_prestataire

//        val imageView: ImageView = view.findViewById(R.id.id_page_presta_img)
//        imageView.setImageResource(prestataire.image_page)

        val textAProposView: TextView = view.findViewById(R.id.id_page_presta_text)
        textAProposView.text = prestataire.text_a_propos

        if (prestataire.commentaires.size == 0) {
            val pasCommentaireTextView: TextView = view.findViewById(R.id.id_pas_commentaire)
            pasCommentaireTextView.visibility = View.VISIBLE
        } else {
            val recyclerView: RecyclerView = view.findViewById(R.id.id_recyclerView_page_presta)
            recyclerView.adapter = DetailPrestaAdapter(prestataire.commentaires)
            recyclerView.setHasFixedSize(true)
        }

        // Add callback to detect when the up arrow button is pressed
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Navigate back to fragment_map
            findNavController().navigateUp()

            // Remove DetailPrestaFragment from the back stack
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val fragment = fragmentManager?.findFragmentById(R.id.detailPrestaFragment)
        if (fragment != null) {
            fragmentManager?.beginTransaction()?.remove(fragment)?.commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val textViewPrestataireName = view?.findViewById<TextView>(R.id.id_page_presta_nom)
        textViewPrestataireName?.let {
            outState.putString("nom_prestataire", it.text.toString())
        }
    }
}