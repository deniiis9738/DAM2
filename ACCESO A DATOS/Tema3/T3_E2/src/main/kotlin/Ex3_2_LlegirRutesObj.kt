import java.io.*

fun main() {
    val fi = ObjectInputStream(FileInputStream("Rutes.obj"))

    try {
        while (true) {
            var ruta = fi.readObject() as Ruta
            ruta.mostrarRuta()
        }
    } catch (eof: EOFException) {
        fi.close()
    }
}