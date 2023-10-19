package PDF31.Problema1

object Maths {
    val PI = 3.1416

    fun random(min: Int, max: Int): Int {
        return ((Math.random() * (max + 1 - min)) + min).toInt()
    }
}