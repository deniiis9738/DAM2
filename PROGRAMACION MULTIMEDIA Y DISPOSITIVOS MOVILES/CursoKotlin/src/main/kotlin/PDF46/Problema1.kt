package PDF46

fun main() {
    var countries = mapOf(Pair("España", 1), Pair("Italia", 2), Pair("Francia", 3))
//    println(countries)

//    for ((key, value) in countries) {
//        println("Llave: $key con valor: $value")
//    }
//    println(countries.size)
//    println(countries["España"])
    println(countries.get("España"))
}