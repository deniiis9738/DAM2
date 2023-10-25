package PDF39

fun main() {
    val intArray = IntArray(10) { ((Math.random() * 100)).toInt()}

    for (i in intArray) {
        println(i)
    }
    println()

    var quant = 0
    send(intArray, {if (it % 3 == 0) {
        quant++
    } })
    println(quant)
    println()

    var quant2 = 0
    send(intArray, {if (it > 50) {
        quant2 += it
    } })
    println(quant2)
}

fun send(intArray: IntArray, fn: (value: Int) -> Unit) {
    for (i in intArray) {
        fn(i)
    }
}