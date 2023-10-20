package PDF32.Problema1

fun main() {
    var firstPerson = Person("Geroge", 22)
    var employee = Employee("Jose", 15, 5000f)

    firstPerson.showDataPerson()
    employee.showDataPerson()

    if (employee.salary > 3000) {
        println("Debe pagar impuestos")
    } else {
        println("No debe pagar impuestos")
    }


}