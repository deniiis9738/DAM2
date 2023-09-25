package PDF4

import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

fun main() {
    var input = Scanner(System.`in`)

    var (price, cantidad) = askData(input)

    if (isDouble(price) && isInt(cantidad)) {
        var totalPrice = calculateTotalPrice(price, cantidad)
        println("La cantidad a abonar es $totalPrice")
    }
}

private fun askData(input: Scanner): Pair<Double, Int> {
    var price = 0.00
    var quantity = 0

    try {
        print("Introduce el precio de un artículo: ")
        price = input.nextDouble()
    } catch (e: Exception) {
        println("El valor introducido no es un número. ")
        exitProcess(0)
    }
    try {
        print("Introduce la cantidad que lleva un cliente: ")
        quantity = input.nextInt()
    } catch (e: Exception) {
        println("El valor introducido no es un número. ")
    }
    return Pair(price, quantity)
}

fun calculateTotalPrice(price: Double, quantity: Int): Double {
    return price * quantity
}

private fun isDouble(number: Double): Boolean {
    return number != 0.00
}

private fun isInt(number: Int): Boolean {
    return number != 0
}