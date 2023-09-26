package PDF5.Problema4

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    var number = askData()

    if (number >= 10 && number < 100) {
        println("El número tiene dos dígitos")
    } else if (number >= 1 && number < 10) {
        println("El número tiene un dígito")
    }
}

private fun askData(): Int {
    val firstNumber = obtainNumber("Introduce un número: ")
    return firstNumber
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