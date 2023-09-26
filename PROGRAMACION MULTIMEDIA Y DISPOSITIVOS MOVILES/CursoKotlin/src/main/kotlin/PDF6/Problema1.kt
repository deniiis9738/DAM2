package PDF6

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    var (firstNumber, secondNumber) = askData()

    var mayor = if (firstNumber > secondNumber) firstNumber else if (secondNumber > firstNumber) secondNumber else null

    if (mayor != null) println("El mayor es $mayor") else println("Son iguales")
}

private fun askData(): Pair<Int, Int> {
    var firstNumber = obtainNumber("Introduce el primer número: ")
    var secondNumber = obtainNumber("Introduce el segundo número: ")

    return Pair(firstNumber, secondNumber)
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