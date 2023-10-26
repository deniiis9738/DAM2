package PDF46

fun main() {
    var students = mutableMapOf(Pair("España", 1), Pair("Italia", 2), Pair("Francia", 3))
    students.put("Argentina", 4)
    println(students)
}