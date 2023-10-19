package PDF30.Problema2

class Operation(val firstValue: Int, val secondValue: Int, val operationType: OperationType) {
    fun operate() {
        var result = 0

        when (operationType) {
            OperationType.PLUS -> result = firstValue + secondValue
            OperationType.MINUS -> result = firstValue - secondValue
            OperationType.PRODUCT -> result = firstValue * secondValue
            OperationType.DIVISION -> result = firstValue / secondValue
        }
        println("$firstValue ${operationType.type} $secondValue es igaul a $result")
    }
}