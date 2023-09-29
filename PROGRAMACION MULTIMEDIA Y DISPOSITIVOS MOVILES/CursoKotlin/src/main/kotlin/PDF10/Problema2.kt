package PDF10

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    var numbers = 0
    var plus = 0
    do {
        print("Introduce un valor: ")
        var number = input.nextInt()

        plus += number
        numbers++
    } while (number != 0)

    var average = plus / (numbers - 1)
    println("Promedio: $average")
}