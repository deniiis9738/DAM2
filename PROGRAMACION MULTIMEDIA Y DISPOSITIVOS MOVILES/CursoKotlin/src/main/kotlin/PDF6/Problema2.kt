package PDF6

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    var number = askData()

    val result = if (number % 2 == 0) {
        println("Cuadrado")
        Math.pow(number.toDouble(), 2.00)
    } else {
        println("Cubo")
        Math.pow(number.toDouble(), 3.00)
    }

    println("El resultado es $result")

    
}

private fun askData(): Int {
    var number = obtainNumber("Introduce el primer número: ")

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