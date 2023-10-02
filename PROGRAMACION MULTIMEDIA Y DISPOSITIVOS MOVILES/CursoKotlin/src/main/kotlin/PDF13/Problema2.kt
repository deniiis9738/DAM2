package PDF13

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    print("Introduce un número del 1 al 10000: ")
    var number = input.nextInt()
    when (number) {
        in 1..9 -> println("1 dígito")
        in 10 .. 99 -> println("2 dígitos")
        in 100 .. 999 -> println("3 dígitos")
        in 1000 .. 9999 -> println("4 dígitos")
        in 10000 .. 99999 -> println("5 dígitos")
    }
}