package PDF9

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    var i = 1
    var plus = 0

    while (i <= 10) {
        var number = askData()
        i++
        plus += number
    }

    println(plus)
    println(plus / 10)
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