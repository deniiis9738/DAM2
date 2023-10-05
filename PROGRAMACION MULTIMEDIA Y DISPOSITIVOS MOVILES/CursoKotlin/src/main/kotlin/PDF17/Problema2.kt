package PDF17

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    print("Ingresa el primer número: ")
    var firstNumber = input.nextInt()
    print("Ingresa el segundo número: ")
    var secondNumber = input.nextInt()
    println("El número mayor es: ${greater(firstNumber, secondNumber)}")

    print("gerg")
}

private fun greater(firstNumber: Int, secondNumber: Int) = if (firstNumber > secondNumber) firstNumber else secondNumber