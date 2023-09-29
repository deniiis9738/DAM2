package PDF12

import java.util.Scanner

fun main() {
    var input = Scanner(System.`in`)

    for (i in 1 .. 10) {
        print("Introduce un número: ")
        var salary = input.nextInt()
        when {
            salary > 5000 -> println("Sueldo alto")
            salary > 2000 -> println("Sueldo medio")
            else -> println("Sueldo bajo")
        }
    }
}