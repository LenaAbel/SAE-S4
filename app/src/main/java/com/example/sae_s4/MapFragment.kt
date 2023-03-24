package com.example.sae_s4

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup


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
            view.findViewById(R.id.logo14),
            view.findViewById(R.id.logo15),
            view.findViewById(R.id.logo16),
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
                Toast.makeText(requireContext(), "Logo clicked: " + logo.tag, Toast.LENGTH_SHORT)
                    .show()
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle(logo.tag.toString())
                builder.setMessage("Message de la pop-up")
                builder.setPositiveButton("Ok") { dialog, which ->
                    // Action à exécuter lorsque l'utilisateur clique sur le bouton "Ok"
                }
                builder.setNegativeButton("Annuler") { dialog, which ->
                    // Action à exécuter lorsque l'utilisateur clique sur le bouton "Annuler"
                }

                // Afficher la pop-up
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

    private val onCheckedChangeListener = RadioGroup.OnCheckedChangeListener { group, checkedId ->
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