package com.example.sae_s4

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import android.view.GestureDetector
import android.view.MotionEvent


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var logoList: List<ImageView>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("ClickableViewAccessibility", "CutPasteId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        // Get a reference to all the logo ImageViews
        logoList = listOf(
            view.findViewById(R.id.logo),
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
                Toast.makeText(requireContext(), "Logo clicked: " + logo.tag, Toast.LENGTH_SHORT).show()
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
        return view
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment mapFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MapFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
