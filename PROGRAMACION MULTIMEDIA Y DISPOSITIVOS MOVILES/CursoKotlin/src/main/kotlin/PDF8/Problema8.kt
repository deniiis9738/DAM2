package PDF8

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    val firstNumber = obtainNumber("Introduce el primer número: ")
    val secondNumber = obtainNumber("Introduce el segundo número: ")
    val thirdNumber = obtainNumber("Introduce el tercer número: ")

    val greaterNumber = if (firstNumber > secondNumber && firstNumber > thirdNumber) firstNumber
    else if (secondNumber > firstNumber && secondNumber > thirdNumber) secondNumber
    else    thirdNumber

    val lesserNumber = if (firstNumber < secondNumber && firstNumber < thirdNumber) firstNumber
    else if (secondNumber < firstNumber && secondNumber < thirdNumber) secondNumber
    else    thirdNumber

    println(greaterNumber)
    println(lesserNumber)
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