package PDF3

var result: Int = 0

fun main() {
    val firstNumber = 5
    val secondNumber = 7


    println("La suma de ambos números es: ${plusNumbers(firstNumber, secondNumber)}")
    println("El producto de ambos números es: ${productNumbers(firstNumber, secondNumber)}")
}

fun plusNumbers(firstNumber: Int, secondNumber: Int): Int {
    result = firstNumber + secondNumber
    return result
}

fun productNumbers(firstNumber: Int, secondNumber: Int): Int {
    result = firstNumber * secondNumber
    return result
}