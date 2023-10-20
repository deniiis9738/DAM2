package PDF32.Problema1

class Employee(name: String, age: Int, salary: Float): Person(name, age) {
    var salary = 0f

    init {
        this.salary = salary
    }

    override fun showDataPerson() {
        super.showDataPerson()
        println("Sueldo $salary")
    }
}