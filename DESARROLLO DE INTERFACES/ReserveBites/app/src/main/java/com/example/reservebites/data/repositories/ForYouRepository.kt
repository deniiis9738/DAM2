package com.example.reservebites.data.repositories

import com.example.reservebites.R
import com.example.reservebites.data.models.RestaurantCard

class ForYouRepository {
    fun getRestaurantList(): List<RestaurantCard> {
        return listOf(
            RestaurantCard("La Taberna del Olivo", R.drawable.tabernaolivo,"Sumérgete en la tradición culinaria española en La Taberna del Olivo. Nuestro acogedor restaurante ofrece auténticos platos caseros, desde paellas llenas de sabores hasta tapas deliciosamente variadas.", 4f),
            RestaurantCard("El Rincón Ibérico", R.drawable.rinconiberico, "Descubre la riqueza de los sabores ibéricos en El Rincón Ibérico. Nuestro menú destaca los mejores jamones, quesos y vinos de la región, creando una experiencia gastronómica que te transportará directamente a la península.", 2f),
            RestaurantCard("Mariscos de la Costa", R.drawable.mariscoscosta,"Mariscos de la Costa te invita a disfrutar de la frescura del mar en cada bocado. Con una selección variada de mariscos y pescados, nuestro restaurante te lleva a un viaje culinario por las costas de España.", 1f),
            RestaurantCard("Tapas y Vinos Encantados", R.drawable.tapasyvinosencantados,"En Tapas y Vinos Encantados, experimentarás la magia de las tapas españolas y la diversidad de vinos de la región. Cada pequeño plato cuenta una historia única de sabores que deleitarán tu paladar.", 1f),
            RestaurantCard("Sabores de Andalucía", R.drawable.saboresandalucia,"Viaja a la vibrante región de Andalucía a través de los Sabores de Andalucía. Nuestro restaurante celebra la cocina andaluza con platos típicos como salmorejo, flamenquín y gazpacho, en un ambiente lleno de alegría.", 3f),
            RestaurantCard("Cocina Catalana Contemporánea", R.drawable.cocinacontemporaneacatalana,"Disfruta de una interpretación moderna de la cocina catalana en nuestro restaurante. Con técnicas innovadoras y ingredientes locales, ofrecemos platos que capturan la esencia de la región.", 5f),
            RestaurantCard("El Secreto del Pescador", R.drawable.secretopescador,"En El Secreto del Pescador, descubrirás los tesoros del mar preparados con maestría. Nuestro chef, inspirado por las tradiciones pesqueras españolas, te llevará a un viaje de sabores frescos y auténticos.", 4f),
            RestaurantCard("Mesón del Aceite de Oliva", R.drawable.mesonaceiteoliva,"Sumérgete en el mundo del aceite de oliva en el Mesón del Aceite de Oliva. Desde aceitunas hasta aceites premium, nuestro restaurante destaca la importancia de este ingrediente fundamental en la cocina española.", 4f),
            RestaurantCard("Delicias Gallegas", R.drawable.deliciasgallegas,"Descubre las Delicias Gallegas, donde la cocina de Galicia cobra vida con platos como pulpo a la gallega, empanadas y mariscos frescos. Cada bocado es una invitación a explorar los sabores del norte de España.", 2f),
            RestaurantCard("El Asador Castellano", R.drawable.asadorcastellano,"Disfruta de las carnes a la parrilla en El Asador Castellano. Nuestro restaurante rinde homenaje a la tradición de la cocina castellana con jugosos platos de carne asada y acompañamientos auténticos.", 3f)
        )
    }
}