package PDF9

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    println("Lista 1:")
    var firstList = mutableListOf(5)
    for (i in 1 .. 5) {
        print("Introduce un número: ")
        var n = input.nextInt()
        firstList.add(n)
    }

    println()

    println("Lista 2:")
    var secondList = mutableListOf(5)
    for (i in 1 .. 5) {
        print("Introduce un número: ")
        var n = input.nextInt()
        secondList.add(n)
    }

    var plusFirstList = 0
    for (number in firstList) {
        plusFirstList += number
    }

    var plusSecondList = 0
    for (number in firstList) {
        plusSecondList += number
    }

    if (plusFirstList > plusSecondList) {
        println("Lista 1 mayor")
    } else if (plusSecondList > plusFirstList) {
        println("Lista 2 mayor")
    } else {
        println("Listas iguales")
    }
}