package PDF21

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    var hightArray = FloatArray(5)

    for (i in 0 ..< hightArray.size) {
        print("Introduce una altura: ")
        var height = input.nextFloat()
        hightArray[i] = height
    }

    var average = averageHight(hightArray)
    println("La media de alturas es: $average")

    var higherPeople = 0
    var shorterPeople = 0

    for (i in 0 ..< hightArray.size) {
        if (hightArray[i] > average) {
            higherPeople++
        } else {
            shorterPeople++
        }
    }
    println("Personas más altas que el promedio: $higherPeople")
    println("Personas más bajas que el promedio: $shorterPeople")
}

fun averageHight(hightArray: FloatArray): Float {
    var plus = 0f

    for (i in 0 ..< hightArray.size) {
        plus += hightArray[i]
    }
    return plus / hightArray.size
}