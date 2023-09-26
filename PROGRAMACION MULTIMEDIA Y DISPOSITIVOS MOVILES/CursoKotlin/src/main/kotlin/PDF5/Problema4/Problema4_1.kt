package PDF5.Problema4

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    var results = askData()

    var firstResult = results.firstResult
    var secondResult = results.secondResult
    var thirdResult = results.thirdResult

    if (calculateAverage(firstResult, secondResult, thirdResult) >= 7) {
        println("Promocionado")
    }
}

private fun askData(): Results {
    val firstResult = obtainNumber("Introduce la primera nota: ")
    val secondResult = obtainNumber("Introduce la segunda nota: ")
    val thirdResult = obtainNumber("Introduce la tercera nota: ")

    var results = Results(firstResult, secondResult, thirdResult)
    return results
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

fun calculateAverage(firstNumber: Int, secondNumber: Int, thirdNumber: Int): Int {
    return (firstNumber + secondNumber + thirdNumber) / 3
}