package PDF3

fun main() {
    val firstPerson = 70f
    val secondPerson = 89f
    val thirdPerson = 90f

    val avergaeWeight = calculateAvergaeWeight(firstPerson, secondPerson, thirdPerson)

    println("El promedio de pesos de las personas es $avergaeWeight" + "kg")
}

fun calculateAvergaeWeight(firstPerson: Float, secondPerson: Float, thirdPerson: Float): Float {
    val avergaeWeight = (firstPerson + secondPerson + thirdPerson) / 3
    return avergaeWeight
}