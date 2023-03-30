package com.example.sae_s4

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.sae.data.DataPrestataires


class MapFragment : Fragment() {

    private lateinit var logoList: List<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("ClickableViewAccessibility", "CutPasteId, MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_map, container, false)

        logoList = listOf(
            view.findViewById(R.id.logo1),
            view.findViewById(R.id.logo2),
            view.findViewById(R.id.logo3),
            view.findViewById(R.id.logo4),
            view.findViewById(R.id.logo5),
            view.findViewById(R.id.logo6),
            view.findViewById(R.id.logo7),
            view.findViewById(R.id.logo8),
            view.findViewById(R.id.logo9),
            view.findViewById(R.id.logo10),
            view.findViewById(R.id.logo11),
            view.findViewById(R.id.logo12),
            view.findViewById(R.id.logo13),
            view.findViewById(R.id.logo17),
            view.findViewById(R.id.logo18),
            view.findViewById(R.id.logo19),
            view.findViewById(R.id.logo20),
            view.findViewById(R.id.logo21),
            view.findViewById(R.id.logo22),
        )

        // Add onClickListener to each logo ImageView
        logoList.forEach { logo ->
            logo.setOnClickListener {
                Log.d("MapFragment", "Logo clicked")
                val builder = AlertDialog.Builder(requireContext())

                val titre: String
                if (logo.contentDescription == "resto") {
                    titre = DataPrestataires.restaurants[logo.tag.toString().toInt()].nom_prestataire
                }
                else if (logo.contentDescription == "sport") {
                    titre = DataPrestataires.clubs[logo.tag.toString().toInt()].nom_prestataire
                }
                else
                    titre = logo.tag.toString()

                builder.setTitle(titre)

                // Create a button in the popup to navigate to DetailPrestaFragment
                builder.setPositiveButton("Détails") { _, _ ->
                    if (logo.contentDescription == "resto") {
                        Navigation.findNavController(view)
                            .navigate(
                                R.id.action_detail_presta,
                                bundleOf(
                                    "quel_type_presta" to "resto",
                                    "presta" to logo.tag.toString()
                                )
                            )
                    }
                }

                builder.setNegativeButton("Annuler") { dialog, which ->
                }

                // Show the popup
                val dialog = builder.create()
                dialog.show()
            }
        }

        // Inflate the layout for this fragment
        val rg = view.findViewById<RadioGroup>(R.id.type_presta)
        rg.setOnCheckedChangeListener(onCheckedChangeListener)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private val onCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.resto -> {
                    for (img in logoList) {
                        if (img.contentDescription.equals("resto"))
                            img.visibility = View.VISIBLE
                        else
                            img.visibility = View.INVISIBLE
                    }
                }
                R.id.club -> {
                    for (img in logoList) {
                        if (img.contentDescription.equals("sport"))
                            img.visibility = View.VISIBLE
                        else
                            img.visibility = View.INVISIBLE
                    }
                }
                R.id.magasin -> {
                    for (img in logoList) {
                        if (img.contentDescription.equals("magasin"))
                            img.visibility = View.VISIBLE
                        else
                            img.visibility = View.INVISIBLE
                    }
                }
                R.id.id_btn_reset_filtre_map -> {
                    for (img in logoList)
                        img.visibility = View.VISIBLE
                }
            }
        }
}