package PDF5

import java.lang.Exception
import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    val salary = askData(input)

    if (isInt(salary)) {
        if (salary > 3000) {
            println("El trabajador debe abonar impuestos")
        }
    }
}

private fun askData(input: Scanner): Int {
    var salary = 0

    print("Introduce el sueldo de trabajador: ")
    try {
        salary = input.nextInt()
    } catch (e: Exception) {
        println("El valor introducido no es un número. ")
    }
    return salary
}

private fun isInt(number: Int): Boolean {
    return number != 0
}