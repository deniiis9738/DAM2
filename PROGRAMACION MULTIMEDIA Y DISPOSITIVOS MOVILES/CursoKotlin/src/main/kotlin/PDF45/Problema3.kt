package PDF45

fun main() {
    val list = mutableListOf(41, 15, 36, 18)
    println(list)
    list.add(10)
    println(list)
    list.remove(15)
    println(list)
    list[1] = 99
    println(list)
    println(list.average())
    list.add(0, 100)
    println(list)
    list.clear()
    println(list)
}