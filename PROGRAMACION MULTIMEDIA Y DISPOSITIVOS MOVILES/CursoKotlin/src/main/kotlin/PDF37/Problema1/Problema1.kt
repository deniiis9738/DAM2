package PDF37.Problema1

fun main() {
    val plus = operate(5, 10, {value1, value2 -> value1 + value2})
    println(plus)
    val minus = operate(5, 10, {value1, value2 -> value1 - value2})
    println(minus)
    val square = operate(5, 10, {value1, value2 ->
        var value = 1
        for (i in 1 .. value2) {
            value *= value1
        }
    value}
    )
    println(square)
}

fun operate(value1: Int, value2: Int, fn: (Int, Int) -> Int): Int {
    return fn(value1, value2)
}