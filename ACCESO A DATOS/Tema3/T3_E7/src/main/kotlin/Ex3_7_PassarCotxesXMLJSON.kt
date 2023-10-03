import org.json.JSONArray
import org.json.JSONObject
import org.w3c.dom.Element
import java.io.File
import java.io.FileWriter
import javax.xml.parsers.DocumentBuilderFactory

fun main() {
    val arrayVehiculos = mutableListOf<JSONObject>()

    val factory = DocumentBuilderFactory.newInstance()
    val builder = factory.newDocumentBuilder()

    val file = File("cotxes.xml")
    val doc = builder.parse(file)

    val vehiculos = doc.getElementsByTagName("vehiculo")

    for (i in 0 ..< vehiculos.length) {
        val vehiculoElement = vehiculos.item(i) as Element

        val vehiculoJSON = JSONObject()
        vehiculoJSON.put("marca", vehiculoElement.getElementsByTagName("marca").item(0).textContent)
        val modeloElement = vehiculoElement.getElementsByTagName("modelo").item(0) as Element
        val modeloJSON = JSONObject()
        vehiculoJSON.put("modelo", modeloJSON)
        modeloJSON.put("color", modeloElement.getAttribute("color"))
        modeloJSON.put("nombre_modelo", vehiculoElement.getElementsByTagName("modelo").item(0).textContent)
        val motorJSON = JSONObject()
        vehiculoJSON.put("motor", motorJSON)
        motorJSON.put("combustible", (vehiculoElement.getElementsByTagName("motor").item(0) as Element).getAttribute("combustible"))
        motorJSON.put("nombre_motor", vehiculoElement.getElementsByTagName("motor").item(0).textContent)
        vehiculoJSON.put("matricula", vehiculoElement.getElementsByTagName("matricula").item(0).textContent)
        vehiculoJSON.put("kilometros", vehiculoElement.getElementsByTagName("kilometros").item(0).textContent)
        vehiculoJSON.put("precio_inicial", vehiculoElement.getElementsByTagName("precio_inicial").item(0).textContent)
        vehiculoJSON.put("precio_oferta", vehiculoElement.getElementsByTagName("precio_oferta").item(0).textContent)

        val extras = vehiculoElement.getElementsByTagName("extra")
        val extrasArray = JSONArray()
        for (j in 0 ..< extras.length) {
            val extraElement = extras.item(j) as Element
            val extraJSON = JSONObject()
            extraJSON.put("nombre", extraElement.textContent)
            extraJSON.put("valor", extraElement.getAttribute("valor"))
            extrasArray.put(extraJSON)
        }
        vehiculoJSON.put("extras", extrasArray)

        val fotos = vehiculoElement.getElementsByTagName("foto")
        val fotosArray = JSONArray()
        for (j in 0 ..< fotos.length) {
            val fotoElement = fotos.item(j) as Element
            fotosArray.put(fotoElement.textContent)
        }
        vehiculoJSON.put("fotos", fotosArray)

        arrayVehiculos.add(vehiculoJSON)
    }

    val arrelJSON = JSONObject()
    val ofertaJSON = JSONObject()
    arrelJSON.put("oferta", ofertaJSON)
    ofertaJSON.put("vehiculos", arrayVehiculos)

    val fo = FileWriter("cotxes.json")
    fo.write(arrelJSON.toString(4))
    fo.close()
}