import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main() {
    val fi = ObjectInputStream(FileInputStream("Rutes.obj"))

    val doc = DocumentBuilderFactory.newInstance ().newDocumentBuilder().newDocument()
    val rutes = doc.createElement ("rutes")
    doc.appendChild(rutes)

    try {
        while (true) {
            val ruta = fi.readObject() as Ruta
            val rutaElement = doc.createElement ("ruta")

            val nom = doc.createElement ("nom")
            nom.appendChild(doc.createTextNode(ruta.nom))
            rutaElement.appendChild(nom)

            val desnivell = doc.createElement ("desnivell")
            desnivell.appendChild(doc.createTextNode(ruta.desnivell.toString()))
            rutaElement.appendChild(desnivell)

            val desnivellAcumulat = doc.createElement ("desnivellAcumulat")
            desnivellAcumulat.appendChild(doc.createTextNode(ruta.desnivellAcumulat.toString()))
            rutaElement.appendChild(desnivellAcumulat)

            val punts = doc.createElement ("punts")
            rutaElement.appendChild(punts)

            var i = 0
            for (punt in ruta.llistaDePunts) {
                val punt = doc.createElement ("punt")
                punts.appendChild(punt)
                punt.setAttribute("num", (i + 1).toString())

                val nom = doc.createElement ("nom")
                nom.appendChild(doc.createTextNode(ruta.getPuntNom(i)))
                punt.appendChild(nom)

                val latitud = doc.createElement ("latitud")
                latitud.appendChild(doc.createTextNode(ruta.getPuntLatitud(i).toString()))
                punt.appendChild(latitud)

                val longitud = doc.createElement ("longitud")
                longitud.appendChild(doc.createTextNode(ruta.getPuntLongitud(i).toString()))
                punt.appendChild(longitud)

                i++
            }
            rutes.appendChild(rutaElement)
        }
    } catch (eof: EOFException) {
        fi.close()
    }
    val trans = TransformerFactory.newInstance().newTransformer()
    trans.setOutputProperty(OutputKeys.INDENT, "yes")
    trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")

    trans.transform(DOMSource(doc), StreamResult("Rutes.xml"))
}