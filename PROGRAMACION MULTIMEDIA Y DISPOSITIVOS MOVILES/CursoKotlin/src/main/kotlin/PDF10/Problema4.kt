package PDF10

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    var plus = 0
    do {
        print("Introduce un número: ")
        var number = input.nextInt()
        if (number != 9999) {
            plus += number
        }
    } while (number != 9999)

    println("La suma es: $plus")
    if (plus > 0) {
        print("Mayor a 0")
    } else if (plus < 0) {
        println("Menor a 0")
    } else {
        println("Cero")
    }
}