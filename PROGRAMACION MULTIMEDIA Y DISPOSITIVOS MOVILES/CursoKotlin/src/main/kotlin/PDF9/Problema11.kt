package PDF9

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    print("Introduce un valor: ")
    var number = input.nextInt()

    var even = 0
    var odd = 0
    for (i in 1 .. number) {
        print("Introduce un número: ")
        var n = input.nextInt()

        if (n % 2 == 0) {
            even++
        } else {
            odd++
        }
    }

    println("Números pares: $even")
    println("Números impares: $odd")
}