package com.example.sae_s4.prestataire
data class Prestataire(

    val nom_prestataire: String,
//    val email_prestataire: String,
//    val telephone_prestataire: String,
    val site_web: String,
    val text_a_propos: String,
    val image_globale: Int,
    val commentaires: MutableList<Commentaire>
)

data class Commentaire(
    val nom_auteur: String,
    val libelle_commentaire: String,
    val libelle_note: String
)