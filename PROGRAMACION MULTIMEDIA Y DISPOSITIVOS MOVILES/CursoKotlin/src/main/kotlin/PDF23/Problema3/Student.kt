package PDF23.Problema3

import java.util.Scanner

class Student() {
    var name = ""
    var result = 0f

    init {
        var input = Scanner(System.`in`)
        print("Escribe el nombre: ")
        var name = input.next()
        this.name = name
        print("Escribe la nota del examen: ")
        var result = input.nextFloat()
        this.result = result
    }

    fun showProperties() {
        println("El nombre del alumno es: $name")
        println("La nota del alumno es: $result")
    }

    fun resultExamen() {
        if (result >= 4) println("Regular") else println("Irregular")
    }
}