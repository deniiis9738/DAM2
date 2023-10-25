package PDF38

fun main() {
    val intArray =  IntArray(20) {((Math.random() * 10) + 1).toInt()}

    println("Elementos del array")
    for (i in intArray) {
        println(i)
    }

    val quant1 = intArray.count {it <= 5}
    println("Cantidad de elementos menores o iguales a 5: $quant1")

    if (intArray.all {it <= 9}) {
        println("Todos los elementos son menores o iguales a 9")
    }

    if (intArray.any {it == 10}) {
        println("Hay un 10")
    }
}