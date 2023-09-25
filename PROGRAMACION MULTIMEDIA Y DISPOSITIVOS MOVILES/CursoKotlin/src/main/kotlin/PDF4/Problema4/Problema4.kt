package PDF4.Problema4

import java.util.*
import kotlin.system.exitProcess

fun main() {

    var numbers = askData()

    val firstNumber = numbers.firstNumber
    val secondNumber = numbers.secondNumber
    val thirdNumber = numbers.thirdNumber
    val fourthNumber = numbers.fourthNumber

    if (isInt(firstNumber) && isInt(secondNumber) && isInt(thirdNumber) && isInt(fourthNumber)) {
        var plusFirstAndSecondNumber = calculatePlusFirstAndSecondNumber(firstNumber, secondNumber)
        println("La suma de $firstNumber + $secondNumber es $plusFirstAndSecondNumber")
        var productThirdAndFourthNumber = calculateProductThirdAndFourthNumber(thirdNumber, fourthNumber)
        println("El producto de $thirdNumber * $fourthNumber es $productThirdAndFourthNumber")
        var plusNumbers = calculatePlus(firstNumber, secondNumber, thirdNumber, fourthNumber)
        println("La suma de $firstNumber + $secondNumber + $thirdNumber + $fourthNumber es $plusNumbers")
        var average = calculateAverage(firstNumber, secondNumber, thirdNumber, fourthNumber)
        println("El promedio de $firstNumber, $secondNumber, $thirdNumber, $fourthNumber es $average")
    }
}

private fun askData(): Numbers {
    val firstNumber = obtainNumber("Introduce el primer número: ")
    val secondNumber = obtainNumber("Introduce el segundo número: ")
    val thirdNumber = obtainNumber("Introduce el tercer número: ")
    val fourthNumber = obtainNumber("Introduce el cuarto número: ")

    var numbers = Numbers(firstNumber, secondNumber, thirdNumber, fourthNumber)
    return numbers
}

fun obtainNumber(mensaje: String): Int {
    var input = Scanner(System.`in`)
    try {
        print(mensaje)
        return input.nextInt()
    } catch (e: Exception) {
        println("El valor introducido no es un número válido.")
        exitProcess(0)
    }
}

fun calculatePlusFirstAndSecondNumber(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber + secondNumber
}

fun calculateProductThirdAndFourthNumber(thirdNumber: Int, fourthNumber: Int): Int {
    return thirdNumber * fourthNumber
}

fun calculatePlus(firstNumber: Int, secondNumber: Int, thirdNumber: Int, fourthNumber: Int): Int {
    return firstNumber + secondNumber + thirdNumber + fourthNumber
}

fun calculateAverage(firstNumber: Int, secondNumber: Int, thirdNumber: Int, fourthNumber: Int): Int {
    return calculatePlus(firstNumber, secondNumber, thirdNumber, fourthNumber) / 4
}

private fun isInt(number: Int): Boolean {
    return number != 0
}