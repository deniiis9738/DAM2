package PDF4

import java.util.Scanner
import kotlin.system.exitProcess

fun main() {
    var input = Scanner(System.`in`)

    var (firstNumber, secondNumber) = askData(input)

    if (isDouble(firstNumber) && isDouble(secondNumber)) {
        var plusNumbers = calculatePlusNumbers(firstNumber, secondNumber)
        println("La suma de los números es $plusNumbers")
        var productNumbers = calculateProductNumbers(firstNumber, secondNumber)
        println("El producto de los números es $productNumbers")
    }
}

private fun askData(input: Scanner): Pair<Int, Int> {
    var firstNumber = 0
    var secondNumber = 0

    try {
        print("Introduce el primer número: ")
        firstNumber = input.nextInt()
    } catch (e: Exception) {
        println("El primer número introducido no es un número. ")
        exitProcess(0)
    }
    try {
        print("Introduce el segundo número: ")
        secondNumber = input.nextInt()
    } catch (e: Exception) {
        println("El segundo número introducido no es un número. ")
    }
    return Pair(firstNumber, secondNumber)
}

fun calculatePlusNumbers(firstNumber: Int, secondNumber: Int): Int {
    var plusNumbers = firstNumber + secondNumber
    return plusNumbers
}

fun calculateProductNumbers(firstNumber: Int, secondNumber: Int): Int {
    var productNumbers = firstNumber * secondNumber
    return productNumbers
}

private fun isDouble(number: Int): Boolean {
    return number != 0
}