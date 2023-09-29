package PDF10

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    var piecesLessWeight = 0f
    var piecesMidWeight = 0f
    var piecesMoreWeight = 0f
    var pieces = 0
    do {
        print("Introduce el peso: ")
        var kg = input.nextInt()

        if (kg >= 9.8 && kg <= 10.2) {
            piecesMidWeight++
        } else if (kg > 10.2) {
            piecesMoreWeight++
        } else if (kg < 9.8 && kg > 0) {
            piecesLessWeight++
        }
        pieces++
    } while (kg != 0)

    pieces -= 1
    println("Piezas: $pieces")
    println("Piezas de poco peso: $piecesLessWeight")
    println("Piezas de medio peso: $piecesMidWeight")
    println("Piezas de mucho peso: $piecesMoreWeight")
}