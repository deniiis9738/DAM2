package PDF9

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    var i = 1
    var greatterThanSeven = 0
    var lesserThanSeven = 0

    while (i <= 10) {
        print("Introduce una nota: ")
        var result = input.nextFloat()

        if (result >= 7) {
            greatterThanSeven++
        } else {
            lesserThanSeven++
        }
        i++
    }

    println("Notas mayores que 7: $greatterThanSeven")
    println("Notas menores que 7: $lesserThanSeven")
}