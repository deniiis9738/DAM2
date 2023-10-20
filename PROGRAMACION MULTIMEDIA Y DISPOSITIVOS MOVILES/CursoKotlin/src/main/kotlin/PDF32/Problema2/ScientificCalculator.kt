package PDF32.Problema2

class ScientificCalculator(firstValue: Float, secondValue: Float): Calculator(firstValue, secondValue) {
    fun square(): Float {
        return Math.pow(firstValue.toDouble(), 2.0).toFloat()
    }

    fun squareRoot(): Float {
        return Math.sqrt(firstValue.toDouble()).toFloat()
    }
}