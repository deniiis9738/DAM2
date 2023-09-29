package PDF9

import java.util.*

fun main() {
    var input = Scanner(System.`in`)

    print("Introduce n empleados: ")
    var employees = input.nextInt()

    var i = 1
    var plus = 0
    var quantPoor = 0
    var quantMinusPoor = 0

    while (i <= employees) {
        print("Introduce su salario: ")
        var salary = input.nextInt()

        if (salary >= 100 && salary <= 300) {
            quantPoor++
        } else {
            quantMinusPoor++
        }

        plus += salary

        i++
    }
    println("Personas que cobran entre 100 y 300: $quantPoor")
    println("Personas que cobran más de 300: $quantMinusPoor")
    println("El personal se gasta en sus empleados $plus")
}