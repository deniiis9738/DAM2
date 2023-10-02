package PDF13

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    print("Introduce un número del 1 al 5: ")
    var number = input.nextInt()
    when (number) {
        1 -> println("uno")
        2 -> println("dos")
        3 -> println("tres")
        4 -> println("cuatro")
        5 -> println("cinco")
    }
}