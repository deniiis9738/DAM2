package PDF6

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    val number = askData()

    val digits = if (number in 10..99) {
        2
    } else if (number in 1..9){
        1
    } else {
        null
    }

    println(digits)
}
private fun askData(): Int {
    var number = obtainNumber("Introduce un número entre 1 y 99: ")

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