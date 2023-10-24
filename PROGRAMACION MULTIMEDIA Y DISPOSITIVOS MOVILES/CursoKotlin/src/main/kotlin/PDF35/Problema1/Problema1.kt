package PDF35.Problema1

fun main() {
    var personArray: Array<Person>
    personArray = arrayOf(Person("Geroge", 18),
        Person("Carlos", 14),
        Person("Jose", 26))

    var quantLegalAge = 0
    for (person in personArray) {
        person.show()
        if (person.legalAge()) {
            quantLegalAge++
        }
    }
    println("Són mayores de edad $quantLegalAge personas")
}