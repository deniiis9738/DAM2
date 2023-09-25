import java.io.DataInputStream
import java.io.FileInputStream
fun main(args: Array<String>) {
    val f = DataInputStream(FileInputStream("Rutes.dat"))

    while (f.available() > 0) {
        println("Ruta: " + f.readUTF())
        println("Desnivell: " + f.readInt())
        println("Desnivell acumulat: " + f.readInt())
        var punts = f.readInt()
        println("Té " + punts + " punts")
        for (i in 1..punts) {
            println("Punt " + i + ": " + f.readUTF() + " (" + f.readDouble() + ", " + f.readDouble() + ")")
        }
        println()
    }
    f.close()
}