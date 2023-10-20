package PDF32.Problema1

open class Person(name: String, age: Int) {
    var name = ""
    var age = 0

    init {
        this.name = name
        this.age = age
    }

    open fun showDataPerson() {
        println("Nombre $name")
        println("Edad $age")
    }
}