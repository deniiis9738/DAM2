package PDF5

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    var (firstNumber, secondNumber) = askData()

    var greaterNumber = greaterNumber(firstNumber, secondNumber)
    if (greaterNumber == null) {
        println("Son iguales")
    } else {
        println("El número más alto entre $firstNumber y $secondNumber es $greaterNumber")
    }
}

private fun askData(): Pair<Int, Int> {
    var firstNumber = obtainNumber("Introduce el primer número: ")
    var secondNumber = obtainNumber("Introduce el segundo número: ")

    return Pair(firstNumber, secondNumber)
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

private fun greaterNumber(firstNumber: Int, secondNumber: Int): Int? {
    if (firstNumber > secondNumber) {
        return firstNumber
    } else if (secondNumber > firstNumber) {
        return secondNumber
    } else {
        return null
    }
}