package PDF11

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    var resultMoreEqualSeven = 0
    var resultMinusSeven = 0

    for (i in 1 .. 10) {
        var number = askData()

        if (number >= 7) {
            resultMoreEqualSeven++
        }else {
            resultMinusSeven++
        }
    }

    println("Notas mayores o igual a 7: $resultMoreEqualSeven")
    println("Notas menores a 7: $resultMinusSeven")
}

private fun askData(): Int {
    var number = obtainNumber("Introduce un número entre 1 y 10: ")

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