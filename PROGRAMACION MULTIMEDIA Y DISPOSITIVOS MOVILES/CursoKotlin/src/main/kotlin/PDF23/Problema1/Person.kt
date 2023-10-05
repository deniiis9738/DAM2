package PDF23.Problema1

class Person(name: String, years: Int) {
    var name = ""
    var years = 0

    init {
        this.name = name
        this.years = years
    }

    fun showProperties() {
        println("Nombre: $name")
        println("Edad: $years")
    }

    fun adult() {
        if (years >= 18) {
            println("Es mayor de edad")
        } else {
            println("Es menor de edad")
        }
    }
}