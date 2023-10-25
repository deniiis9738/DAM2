package PDF40

fun main() {
    val text = "Magdalena"
    println(text.firstPart())
    println(text.secondPart())
}

fun String.firstPart(): String {
    return this.substring(0 .. this.length / 2 - 1)
}

fun String.secondPart(): String {
    return this.substring(this.length / 2 .. this.length - 1)
}