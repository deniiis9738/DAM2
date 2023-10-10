package PDF26.Problema2

class Dice() {
    var value = 0

    init {
        this.value = value
    }

    fun rollTheDice(): Int {
        value = ((Math.random() * 6) + 1).toInt()
        return value
    }

    fun impressValueDice() {
        println("El valor del dado es: $value")
    }
}