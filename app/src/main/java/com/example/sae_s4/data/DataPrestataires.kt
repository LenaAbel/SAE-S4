package com.example.sae.data

import com.example.sae_s4.R
import com.example.sae_s4.prestataire.Prestataire
import com.example.sae_s4.prestataire.Commentaire

class DataPrestataires {
    companion object {
        val restaurants: MutableList<Prestataire> = mutableListOf(
            Prestataire(
                "Subway",
                "https://www.just-eat.fr/subway",
                "En 1965, Fred DeLuca voulait accomplir son rêve et devenir médecin. Alors qu'il cherchait un moyen de contribuer au financement de ses études, un ami de la famille, le Dr Peter Buck,  lui a suggéré d'ouvrir un restaurant de sandwiches « sous-marin ».\n" +
                        "Le premier restaurant a été ouvert à Bridgeport dans le Connecticut en août 1965. Ils se fixèrent ensuite l'objectif d'ouvrir 32 restaurants en 10 ans.\n" + "Fred DeLuca apprit rapidement les bases de la gestion d'une société et réalisa l'importance de proposer des produits bien faits et de grande qualité et de fournir un excellent service client. Ces leçons continuent de servir de fondements aux restaurants Subway® du monde entier.",
                R.drawable.img_resto_1,
                mutableListOf(
                    Commentaire("Benzai", "Très bon service, rapide, et délicieux 😋 !", "10 / 10"),
                    Commentaire(
                        "Valérie",
                        "Service rapide et on comprend vite pourquoi ...",
                        "2 / 10"
                    )
                )
            ),
            Prestataire(
                "Le camion qui fume",
                "https://lecamionquifume.com",
                "Fondé en 2011 par Kristin Frederick, une américaine expatriée, le restaurant est connu pour ses burgers savoureux, préparés avec des ingrédients de qualité et servis depuis un camion aménagé.\n" +
                        "Le succès du Camion Qui Fume a rapidement fait le tour de la ville, et le restaurant a rapidement acquis une grande popularité auprès des parisiens en quête de bonnes adresses culinaires. Aujourd'hui, le Camion Qui Fume a plusieurs camions-restaurant qui parcourent les rues de Paris et d'autres villes françaises.",
                R.drawable.img_resto_2,
                mutableListOf(
                    Commentaire("Peddro", "La viande est délicieuse !!!", "8.5 / 10"),
                    Commentaire(
                        "Marianne",
                        "Très bon resto, mes enfants et moi sommes ravis !",
                        "6.8 / 10"
                    ),
                    Commentaire(
                        "Benoit",
                        "Je ne regrette pas du tout y être allé avec ma fille 🙂",
                        "9.8 / 10"
                    )
                )
            ),
            Prestataire(
                "Courtepaille",
                "https://www.courtepaille.com",
                "Courtepaille est une chaîne de restaurants français spécialisée dans les grillades de viande. Fondée en 1961, la chaîne compte plus de 270 restaurants en France.\n"+
                        "Le restaurant Courtepaille propose une carte variée de grillades, de salades et d'autres plats traditionnels français, préparés avec des ingrédients frais et de qualité. Les clients peuvent également profiter d'un menu enfant et de formules adaptées aux groupes.",
                R.drawable.img_resto_3,
                mutableListOf(

                )
            ),
            Prestataire(
                "La Citadelle de Belfort",
                "https://www.belfort-tourisme.com/restaurant/cafe-restaurant-de-la-citadelle",
                "La Citadelle de Belfort est un restaurant situé dans l'enceinte de la citadelle de Belfort, monument historique de la ville. Le restaurant propose une cuisine française traditionnelle, préparée avec des produits locaux et de saison.\n" +
                        "Le restaurant propose également des visites guidées de la citadelle, permettant de découvrir l'histoire et l'architecture de ce monument emblématique de la ville de Belfort. Une expérience unique pour les visiteurs qui souhaitent combiner découverte culturelle et gastronomique.",
                R.drawable.img_resto_4,
                mutableListOf(
                    Commentaire("Cheikh", "Je recommande.", "7.4 / 10"),
                )
            )
        )
    }
}