package PDF28.Problema3

class Dice {

    var value = 0

        set(value) {
            if (value in 1..6) {
                field = value
            } else {
                field = 1
            }
        }

        get() {
            return field
        }

    fun rollTheDice(): Int {
        value = ((Math.random() * 6) + 1).toInt()
        return value
    }

    fun showValue(value: Int) {
        println(value)
    }
}