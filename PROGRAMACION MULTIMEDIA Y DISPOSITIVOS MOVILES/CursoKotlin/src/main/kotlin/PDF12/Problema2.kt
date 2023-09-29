package PDF12

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    print("Primera nota: ")
    var firstResult = input.nextInt()
    print("Segunda nota: ")
    var secondResult = input.nextInt()
    print("Tercera nota: ")
    var thirdResult = input.nextInt()

    var average = (firstResult + secondResult + thirdResult) / 3

    when {
        average >= 7 -> println("Promocionado")
        average >= 4 -> println("Regular")
        average < 4 -> println("Reprobado")
    }
}