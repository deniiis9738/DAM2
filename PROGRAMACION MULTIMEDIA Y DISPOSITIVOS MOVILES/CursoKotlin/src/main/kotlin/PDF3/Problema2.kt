package PDF3

fun main() {
    val sideSquare = 50

    val surface = calculateSurface(sideSquare)
    val perimeter = calculatePerimeter(sideSquare)

    println("La superfície del cuadrado con lado $sideSquare es $surface")
    println("El perìmetro del cuadrado con lado $sideSquare es $perimeter")
}

fun calculateSurface(sideSquare: Int): Int {
    val surface = sideSquare * sideSquare
    return surface
}

fun calculatePerimeter(sideSquare: Int): Int {
    val perimeter = sideSquare * 4
    return perimeter
}