package PDF42

fun main() {
    var total = plus(5, 8, 9, 15)

    println(total)
}

fun plus(vararg values: Int): Int {
    var total = 0

    for (i in values) {
        total += i
    }

    return total
}