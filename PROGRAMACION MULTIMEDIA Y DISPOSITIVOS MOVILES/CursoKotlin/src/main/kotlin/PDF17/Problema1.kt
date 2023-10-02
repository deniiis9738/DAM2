package PDF17

import java.util.Scanner

fun main() {
    var input = Scanner(System.`in`)

    print("Ingresa el lado: ")
    var side = input.nextInt()
    println("La superfície del cuadrado es: ${surface(side)}")
}

private fun surface(side: Int) = side * side