import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main() {
    val f = ObjectInputStream(FileInputStream("Rutes.obj"))

    try {
        while (true) {
            val e = f.readObject() as Rutes
        }
    } catch (eof: EOFException) {
        f.close()
    }
}