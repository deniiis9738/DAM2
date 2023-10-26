package PDF45

fun main() {
    var list = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    println("Días de la semana")
    println(list)
    for(posicion in list) {
        print("$posicion ")
    }
}