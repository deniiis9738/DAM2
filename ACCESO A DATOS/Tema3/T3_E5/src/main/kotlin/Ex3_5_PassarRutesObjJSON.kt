import com.squareup.moshi.Moshi
import java.io.EOFException
import java.io.FileInputStream
import java.io.FileWriter
import java.io.ObjectInputStream

fun main() {
    try {
        val arrayRutes = ArrayList<Ruta>()
        val f = ObjectInputStream(FileInputStream("Rutes.obj"))

        while (true) {
            try {
                val ruta = f.readObject() as Ruta
                arrayRutes.add(ruta)
            } catch (eof: EOFException) {
                break
            }
        }
        val rutes = Rutes(arrayRutes)
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Rutes::class.java)
        val rutesJson = adapter.toJson(rutes)
        val fileWriter = FileWriter("Rutes.json")
        fileWriter.use {
            it.write(rutesJson)
        }
        f.close()
    } catch (eof: EOFException) {
        println("Error")
    }
}