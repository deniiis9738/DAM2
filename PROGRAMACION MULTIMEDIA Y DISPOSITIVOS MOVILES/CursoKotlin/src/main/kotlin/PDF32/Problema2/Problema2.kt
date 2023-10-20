package PDF32.Problema2

fun main() {
    val firstCalculator = Calculator(15f, 3f)
    println(firstCalculator.plus())
    println(firstCalculator.minus())
    println(firstCalculator.product())
    println(firstCalculator.division())

    val secondCalculator = ScientificCalculator(15f, 3f)
    println(secondCalculator.square())
    println(secondCalculator.squareRoot())
}