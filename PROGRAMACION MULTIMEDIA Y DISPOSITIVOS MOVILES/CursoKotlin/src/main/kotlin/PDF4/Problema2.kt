package PDF4

import java.lang.Exception
import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    val sideSquare = askData(input)

    if (isDouble(sideSquare)) {
        val perimeter = calculatePerimeter(sideSquare)
        println("El perìmetro del cuadrado con lado $sideSquare es $perimeter")
    }
}

fun calculatePerimeter(sideSquare: Int): Int {
    val perimeter = sideSquare * 4
    return perimeter
}

private fun askData(input: Scanner): Int {
    var sideSquare = 0

    print("Introduce el lado de un cuadrado: ")
    try {
        sideSquare = input.nextInt()
    } catch (e: Exception) {
        println("El valor introducido no es un número. ")
    }
    return sideSquare
}

private fun isDouble(number: Int): Boolean {
    return number != 0
}