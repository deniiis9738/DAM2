package PDF9

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    print("Introduce n personas: ")
    var persons = input.nextInt()

    var i = 1
    var average = 0.0

    while (i <= persons) {
        print("Introduce una altura: ")
        var height = input.nextFloat()

        average += height

        i++
    }

    println("El promedio de alturas de las personas es: " + average / persons)
}