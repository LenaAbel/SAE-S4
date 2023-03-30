package com.example.sae.data

import com.example.sae_s4.R
import com.example.sae_s4.prestataire.Prestataire
import com.example.sae_s4.prestataire.Commentaire
import com.example.sae_s4.prestataire.DetailPrestaFragment

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
                "Courtepaille est une chaîne de restaurants français spécialisée dans les grillades de viande. Fondée en 1961, la chaîne compte plus de 270 restaurants en France.\n" +
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


        val clubs: MutableList<Prestataire> = mutableListOf(
            Prestataire(
                "Equitation Passion",
                "https://www.equitationpassion.com",
                "Créé en 1997, Equitation Passion est dirigé par la cavalière passionnée et monitrice d’équitation expérimentée Anne-Madeleine Schaeffer.\nProche de Belfort, le centre équestre est implanté dans un cadre verdoyant et logé par Sophie Jeannin, propriétaire des installations.\n" +
                        "A cheval ou à poney, l’enseignement dispensé par 3 monitrices d’équitation diplômées, vous permettra de passer les examens fédéraux, de prendre part à des compétitions départementales, régionales et/ou nationales.",
                R.drawable.img_club_1,
                mutableListOf(
                    Commentaire("Pegasus", "Club bien tenu, chevaux amicaux x )", "10 / 10"),
                    Commentaire(
                        "Petit tonnerre",
                        "Galloper au vent c'est trop bien ! 🐎",
                        "8.9 / 10"
                    )
                )
            ),
            Prestataire(
                "TVB Tours Volley-Ball",
                "https://www.toursvolleyball.com",
                "Le Tours Volley-Ball est l’émanation de la section volley du Tours Etudiant Club, qui, depuis 1940, a maintenu la présence du Volley-Ball en Touraine.",
                R.drawable.img_club_2,
                mutableListOf(
                    Commentaire("Peddro", "C'était amusant (●'◡'●)", "6.6 / 10"),
                    Commentaire(
                        "Marion",
                        "Très bon clubs, mes enfants sont ravis !",
                        "8 / 10"
                    )
                )
            ),
            Prestataire(
                "ASPTT Chartres",
                "https://chartres.asptt.com/activity/petanque",
                "ASPTT Chartres un club omnisports depuis bien longtemps avec plus de 1300 licenciés eureliens ....",
                R.drawable.img_club_3,
                mutableListOf(
                    Commentaire(
                        "Marion",
                        "Pas mal !!! 🙂",
                        "7 / 10"
                    ),
                    Commentaire(
                        "Onyankopo",
                        "Gens très sympatiques 🧆",
                        "7.9 / 10"
                    ),
                    Commentaire(
                        "Mathéo",
                        "Tout donne envie de revenir 😄",
                        "8 / 10"
                    )
                )
            ),
            Prestataire(
                "JDA Dijon Basket",
                "https://www.jdadijon.com",
                "La Jeanne d’Arc a été créée en janvier 1880  sous la forme d’un patronage par l’abbé Bizouard. Ce fut compte tenu du succès du nombre d’adhérents un déménagement dans le quartier de la plaine des roses dans la rue Lacodaire. Par trois fois la Jeanne d’Arc a failli sombrer corps et âme.\n" +
                        "Grace à la volonté à la ténacité de quelques uns il n’en fut rien. Lors de la première guerre mondiale 1914/18 la Jeanne d’Arc comptait plus de 450 membres et 57 manquaient à la fin des hostilités. Aujourd’hui la Jeanne d’Arc limite ses activités à un seul sport le basket grâce à trois Présidents remarquables qui sont Emile Jobart Maurice Lebeau (1946-1967) et Henri Boisselot. (1967-1980).,Suite à une erreur dans un article de presse un journaliste avait mentionné et abrégé JDA  au lieu de Jeanne d’Arc.\n" + "" +
                        "C’est ainsi que JDA restera par la suite la dénomination et le logo du getPrestataire.",
                R.drawable.img_club_4,
                mutableListOf(
                    Commentaire("Cheikh", "Très bon club ⭐⭐⭐", "10 / 10"),
                    Commentaire("Anna", "Au top 🏀, club bien tenu", "8.7 / 10"),
                )
            ),
            Prestataire(
                "Karting (Paul Ricard)",
                "https://www.kartingcircuitpaulricard.com",
                "Entièrement dédié aux loisirs et à la détente le karting est la prolongation de l’esprit du Circuit Paul Ricard, associant sécurité et esthétisme.\n" +
                "Au karting du Circuit Paul Ricard, vivez le kart autrement : \n" +
                "    • Devenez un pilote privilégié au volant de karts “dernière génération” performants et découvrez la qualité de nos installations et de nos infrastructures.\n" +
                "    • Accessible à tous, le karting propose de nombreuses formules : location, stages (enfants, adultes, groupes), organisation de challenge, sessions d’entraînements, séminaires d’entreprises… à des tarifs particulièrement attractifs.",
                R.drawable.img_club_5,
                mutableListOf(
                    Commentaire("BMW", "Une folie ! J'ai adoré ! 😍", "7.4 / 10"),
                )
            )
        )
    }
}