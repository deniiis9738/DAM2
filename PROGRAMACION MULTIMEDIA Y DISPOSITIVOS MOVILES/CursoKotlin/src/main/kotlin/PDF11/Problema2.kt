package PDF11

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    var plus = 0

    for (i in 1 .. 10) {
        var number = askData()
        plus += number
    }

    println("La suma es: $plus")
    println("El promedio es: " + plus / 10)
}

private fun askData(): Int {
    var number = obtainNumber("Introduce un número: ")

    return number
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