package PDF8

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    val firstNumber = obtainNumber("Introduce el primer número: ")
    val secondNumber = obtainNumber("Introduce el segundo número: ")
    val thirdNumber = obtainNumber("Introduce el tercer número: ")

    if (firstNumber < 10 || secondNumber < 10 || thirdNumber < 10) {
        println("Alguno de los números es menor a 10")
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