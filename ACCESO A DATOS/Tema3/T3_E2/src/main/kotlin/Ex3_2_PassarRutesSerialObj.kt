import java.io.DataInputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main(args: Array<String>) {
    val fi = DataInputStream(FileInputStream("Rutes.dat"))
    val fo = ObjectOutputStream(FileOutputStream("Rutes.obj"))

    while (fi.available() > 0) {
        var nombreRuta = fi.readUTF()
        var desnivel = fi.readInt()
        var desnivelAcumulado = fi.readInt()

        var listaPuntos = ArrayList<PuntGeo>()

        var tamanioPuntos = fi.readInt()
        for (i in 1..tamanioPuntos) {
            var nombrePunto = fi.readUTF()
            var latitud = fi.readDouble()
            var longitud = fi.readDouble()
            var coordenada = Coordenades(latitud, longitud)
            var puntoGeo = PuntGeo(nombrePunto, coordenada)
            listaPuntos.add(puntoGeo)
        }
        var ruta = Ruta(nombreRuta, desnivel, desnivelAcumulado, listaPuntos)
        ruta.mostrarRuta()
        fo.writeObject(ruta)
    }
    fi.close()
    fo.close()
}