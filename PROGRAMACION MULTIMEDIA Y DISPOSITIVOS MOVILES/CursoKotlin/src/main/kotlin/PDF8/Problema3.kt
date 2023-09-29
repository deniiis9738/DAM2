package PDF8

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    val day = obtainNumber("Introduce el día: ")
    val month = obtainNumber("Introduce el mes: ")
    val year = obtainNumber("Introduce el año: ")

    if (month == 10 && month == 11 && month == 12) {
        println("Navidad")
    } else {
        println("No es navidad")
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