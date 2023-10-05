package PDF23.Problema2

fun main() {
    var triangle = Triangle(20f, 20f, 20f)

    println("Lado del triángulo mayor " + triangle.sideGreater())
    println("Es equilátero: " + triangle.isEquilateral())
}