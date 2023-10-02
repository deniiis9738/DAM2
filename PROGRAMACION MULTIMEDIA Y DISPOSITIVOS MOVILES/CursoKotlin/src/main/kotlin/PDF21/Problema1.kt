package PDF21

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    val sueldos = IntArray(5)
    for (i in sueldos.indices) {
        print("Introduce el sueldo: ")
        sueldos[i] = input.nextInt()
    }

    for (i in sueldos.indices) {
        val sueldo = sueldos[i]
        var x = i + 1
        println("$x:  $sueldo")
    }
}