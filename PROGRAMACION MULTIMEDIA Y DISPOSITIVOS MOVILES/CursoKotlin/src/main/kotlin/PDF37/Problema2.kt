package PDF37

fun main() {
    var intArray = IntArray(10)
    for (i in 0 ..< intArray.size) {
        intArray[i] = ((Math.random() * 100)).toInt()
    }

    println("Números múltiplos de 2")
    showElement(intArray, {x -> x % 2 == 0})
    println("Números múltiplos de 3 o 5")
    showElement(intArray, {x -> x % 15 == 0})
    println("Números mayores o iguales a 50")
    showElement(intArray, {x -> x >= 50})
    println("Números comprendidos entre 1 y 10, 20 y 30, 90 y 95")
    showElement(intArray, {x -> (x >= 1 && x <= 10) || (x >= 20 && x <= 30) || (x >= 90 && x <= 95) })
}

fun showElement(intArray: IntArray, fn: (value: Int) -> Boolean) {
    for (i in intArray){
        if (fn(i)) {
            println(i)
        }
    }
}