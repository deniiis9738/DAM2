package PDF32.Problema2

open class Calculator(firstValue: Float, secondValue: Float) {
    var firstValue = 0f
    var secondValue = 0f

    init {
        this.firstValue = firstValue
        this.secondValue = secondValue
    }

    fun plus(): Float {
        return firstValue + secondValue
    }

    fun minus(): Float {
        return firstValue - secondValue
    }

    fun product(): Float {
        return firstValue * secondValue
    }

    fun division(): Float {
        return firstValue / secondValue
    }
}