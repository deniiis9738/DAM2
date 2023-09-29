package PDF8

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    val x = obtainNumber("X: ")
    val y = obtainNumber("Y: ")

    if (x > 0 && y > 0) {
        println("Primer cuadrante")
    } else if (x < 0 && y > 0) {
        println("Segundo cuadrante")
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