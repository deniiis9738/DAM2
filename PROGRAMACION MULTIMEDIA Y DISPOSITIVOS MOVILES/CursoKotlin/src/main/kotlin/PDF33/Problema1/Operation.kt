package PDF33.Problema1

abstract class Operation(value1: Int, value2: Int) {
    var value1 = 0
    var value2 = 0
    var result = 0

    init {
        this.value1 = value1
        this.value2 = value2
    }

    abstract fun operate()

    fun show() {
        println("Resultado: $result")
    }
}