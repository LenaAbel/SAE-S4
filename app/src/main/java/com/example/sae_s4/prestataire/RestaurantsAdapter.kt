package com.example.sae_s4.prestataire

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sae_s4.R

class RestaurantsAdapter(
    private val dataRestos: MutableList<Prestataire>,
    private val fragmentResto: RestaurantsFragment
) :
    RecyclerView.Adapter<RestaurantsAdapter.ItemRestoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemRestoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_of_list_prestataires, parent, false)

        return ItemRestoViewHolder(adapterLayout)
    }
    override fun onBindViewHolder(holder: ItemRestoViewHolder, position: Int) {
        val item = dataRestos[position]
        if (position == 0) holder.traiView.visibility = View.INVISIBLE
        holder.textView.text = item.nom_prestataire
        holder.imgView.setImageResource(item.image_globale)
        holder.btnView.setOnClickListener {
            val url = item.site_web
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            fragmentResto.startActivity(intent)
        }
        holder.btnPageView.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_detail_presta, bundleOf("presta" to position.toString()))
        }
    }
    override fun getItemCount(): Int {
        return dataRestos.size
    }
    class ItemRestoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val traiView: View = view.findViewById(R.id.id_trait_resto)
        val imgView: ImageView = view.findViewById(R.id.id_img_presta)
        val textView: TextView = view.findViewById(R.id.id_nom_presta)
        val btnView: Button = view.findViewById(R.id.id_btn_site_presta)
        val btnPageView: Button = view.findViewById(R.id.id_btn_page_presta)
    }
}