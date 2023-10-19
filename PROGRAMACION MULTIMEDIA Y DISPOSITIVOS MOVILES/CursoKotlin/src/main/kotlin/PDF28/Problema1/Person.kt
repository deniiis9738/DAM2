package PDF28.Problema1

class Person() {
    var name = ""

        set(name) {
            field = name.toUpperCase()
        }

        get() {
            return "$field"
        }

    var age = 0

        set(age) {
            if (age >= 0) {
                field = age
            } else {
                field = 0
            }
        }
}