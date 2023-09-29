package PDF10

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    do {
        print("Introduce un valor entre 0 y 999: ")
        var number = input.nextInt()

        if (number >= 0 && number < 10) {
            println("1 dígito")
        } else if (number >= 10 && number < 100) {
            println("2 dígitos")
        } else {
            println("3 dígitos")
        }
    } while (number != 0)
}