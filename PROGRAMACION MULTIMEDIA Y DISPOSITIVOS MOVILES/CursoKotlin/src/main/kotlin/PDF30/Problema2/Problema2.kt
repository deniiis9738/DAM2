package PDF30.Problema2

fun main() {
    val firstOperation = Operation(5, 8, OperationType.PLUS)
    val secondOperation = Operation(5, 8, OperationType.MINUS)
    val thirdOperation = Operation(5, 8, OperationType.PRODUCT)
    val fourthOperation = Operation(5, 8, OperationType.DIVISION)

    firstOperation.operate()
    secondOperation.operate()
    thirdOperation.operate()
    fourthOperation.operate()
}