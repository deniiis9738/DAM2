package PDF7

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    val firstResult = obtainNumber("Introduce la primera nota: ")
    val secondResult = obtainNumber("Introduce la segunda número: ")
    val thirdResult = obtainNumber("Introduce la tercera nota: ")

    val avergae = calculateAverage(firstResult, secondResult, thirdResult)

    if (avergae >= 7) {
        println("Promocionado")
    } else if (avergae >= 4 && avergae < 7) {
        println("Regular")
    } else {
        println("Reprobado")
    }
}

private fun obtainNumber(mensaje: String): Int {
    var input = Scanner(System.`in`)
    try {
        print(mensaje)
        return input.nextInt()
    } catch (e: Exception) {
        println("El valor introducido no es un número válido.")
        exitProcess(0)
    }
}

fun calculateAverage(firstResult: Int, secondResult: Int, thirdResult: Int): Int {
    return (firstResult + secondResult + thirdResult) / 3
}