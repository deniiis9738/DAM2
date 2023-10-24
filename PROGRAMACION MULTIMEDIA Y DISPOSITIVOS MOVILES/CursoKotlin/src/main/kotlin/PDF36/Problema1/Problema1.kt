package PDF36.Problema1

fun main() {
    val result = operate(10, 5, ::plus)
    println("La suma es $result")
}

fun operate(value1: Int, value2: Int, fn: (Int, Int) -> Int): Int {
    return fn(value1, value2)
}

fun plus(value1: Int, value2: Int) = value1 + value2

fun minus(value1: Int, value2: Int) = value1 - value2

fun product(value1: Int, value2: Int) = value1 * value2

fun division(value1: Int, value2: Int) = value1 / value2