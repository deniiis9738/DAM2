package PDF7

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    val firstNumber = obtainNumber("Introduce la primera nota: ")
    val secondNumber = obtainNumber("Introduce la segunda número: ")
    val thirdNumber = obtainNumber("Introduce la tercera nota: ")

    println(greaterNumber(firstNumber, secondNumber, thirdNumber))
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

private fun greaterNumber(firstNumber: Int, secondNumber: Int, thirdNumber: Int): Int? {
    if (firstNumber > secondNumber && firstNumber > thirdNumber) {
        return firstNumber
    } else if (secondNumber > firstNumber && secondNumber > thirdNumber) {
        return secondNumber
    } else {
        return thirdNumber
    }
}