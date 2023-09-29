package PDF7

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    val number = askData()

    if (number >= 10 && number < 100) {
        println("Tiene 2 dígitos")
    } else if (number >= 0 && number < 10) {
        println("Tiene 1 dígito")
    } else {
        println("Tiene 3 dígitos")
    }
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