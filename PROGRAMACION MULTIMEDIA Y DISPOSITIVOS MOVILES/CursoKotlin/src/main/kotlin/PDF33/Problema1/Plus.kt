package PDF33.Problema1

class Plus(value1: Int, value2: Int): Operation(value1, value2) {
    override fun operate() {
        result = value1 +value2
    }
}