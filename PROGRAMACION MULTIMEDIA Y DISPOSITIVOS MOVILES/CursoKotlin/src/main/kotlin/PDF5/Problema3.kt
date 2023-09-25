package PDF5

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    var (firstNumber, secondNumber) = askData()

    if (firstNumber > secondNumber) {
        var calculatePlus = calculatePlus(firstNumber, secondNumber)
        println("La suma de $firstNumber + $secondNumber es $calculatePlus")
        var calculateMinus = calculateMinus(firstNumber, secondNumber)
        println("La resta de $firstNumber - $secondNumber es $calculateMinus")
    } else {
        var calculateProduct = calculateProduct(firstNumber, secondNumber)
        println("El producto de $firstNumber * $secondNumber es $calculateProduct")
        var calculateDivision = calculateDivision(firstNumber, secondNumber)
        println("La división de $firstNumber / $secondNumber es $calculateDivision")

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

fun calculatePlus(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber + secondNumber
}

fun calculateMinus(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber - secondNumber
}

fun calculateProduct(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber * secondNumber
}

fun calculateDivision(firstNumber: Int, secondNumber: Int): Float {
    return firstNumber.toFloat() / secondNumber.toFloat()
}