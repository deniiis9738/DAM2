package com.example.reservebites.data.repositories

class RestaurantRepository {
    fun getReviewsList(): List<String> {
        return listOf(
            "Muy buen servicio",
            "Comida espectacular",
            "De lo mejor que he probado, el personal muy agradable",
            "Podría mejorar el servicio",
            "Precios muy elevados",
            "Sitio muy acogedor"
        )
    }
}