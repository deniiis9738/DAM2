package Exemple_3_3

import java.io.Serializable

class Empleat (var num: Int,var nom: String,var departament: Int,var edat: Int,var sou: Double): Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }
}