package PDF35.Problema1

class Person(name: String, age: Int) {
    var name = ""
    var age = 0

    init {
        this.name = name
        this.age = age
    }

    fun show() {
        println("Nombre: $name")
        println("Edad: $age")
    }

    fun legalAge(): Boolean {
        if (age >= 18) {
            return true
        } else {
            return false
        }
    }
}