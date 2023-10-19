package PDF29.Problema3

data class Dice(var value: Int) {
    override fun toString(): String {
        return "*".repeat(value)
    }
}
