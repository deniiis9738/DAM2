import java.util.Scanner

fun main(args: Array<String>) {
    val lista = arrayListOf(1, 8, 3, 4, 32, 50, 899, 7)
    if (lista.size > 0) {
        val position = askPosition()
        searchPosition(lista, position)
    } else {
        println("Lista vacía")
    }
}

/*fun buscarMedio(lista: ArrayList<Int>): Int {
    var size = lista.size
    var medio: Int
    if (size > 1) {
        if (size % 2 == 0) {
            medio = (size / 2) - 1
        } else {
            medio = size / 2
        }
    } else {
        medio = 1
    }
    return medio
}*/

fun askPosition(): Int {
    val input = Scanner(System.`in`)
    print("Dime que posición que quieres encontrar: ")
    val n = input.nextLine().toInt()
    return n
}

fun searchPosition(lista: ArrayList<Int>, position: Int): Int {
    for ()
    return position
}