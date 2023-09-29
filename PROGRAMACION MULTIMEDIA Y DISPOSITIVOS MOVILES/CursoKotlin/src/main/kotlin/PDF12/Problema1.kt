package PDF12

import java.util.Scanner

fun main() {
    var input = Scanner(System.`in`)

    var x = input.nextInt()
    var y = input.nextInt()

    when {
        x > 0 && y > 0 -> println("Primer cuadrante")
        x < 0 && y > 0 -> println("Segundo cuadrante")
        x < 0 && y < 0 -> println("Tercer cuadrante")
        x > 0 && y < 0 -> println("Cuarto cuadrante")
    }
}