package PDF23.Problema2

class Triangle(side1: Float, side2: Float, side3: Float) {
    var side1 = 0f
    var side2 = 0f
    var side3 = 0f

    init {
        this.side1 = side1
        this.side2 = side2
        this.side3 = side3
    }

    fun sideGreater(): Float {
        if (side1 > side2 && side1 > side3) {
            return side1
        } else if (side2 > side3 && side2 > side1) {
            return side2
        } else {
            return side3
        }
    }

    fun isEquilateral(): Boolean {
        return side1 == side2 && side1 == side3
    }
}