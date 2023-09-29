package PDF9

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    print("Introduce el número de piezas: ")
    var n = input.nextInt()

    var i = 1
    var check = 0

    while (i <= n) {
        print("Introduce la longitud: ")
        var long = input.nextFloat()
        if (long >= 1.20 && long <= 1.30) {
            check++
        }
        i++
    }

    println("Cantidad de piezas válidas: $check")
}