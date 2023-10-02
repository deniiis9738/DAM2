import javax.swing.*
import java.awt.*
import org.w3c.dom.Document
import org.w3c.dom.Element
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory


class Finestra : JFrame() {

    init {
        var doc: Document
        // sentències per a omplir doc
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()

        val file = File("Rutes.xml")
        doc = builder.parse(file)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1,BorderLayout.NORTH)
        add(panell2,BorderLayout.CENTER)

        val llistaRutes = arrayListOf<String>()
        llistaRutes.add("")
        // sentències per a omplir l'ArrayList anterior amb el nom de les rutes
        val rutas = doc.getElementsByTagName("ruta")
        for (i in 0 ..< rutas.length) {
            val rutaElement = rutas.item(i) as Element
            val nomRuta = rutaElement.getElementsByTagName("nom").item(0).textContent
            llistaRutes.add(nomRuta)
        }

        val combo = JComboBox(llistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"),BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener{
            // accions quan s'ha seleccionat un element del combobox,
            // i que han de consistir en omplir el JTextArea
            val rutaSeleccionada = combo.getItemAt(combo.selectedIndex).toString()
            val rutas = doc.getElementsByTagName("ruta")
            var puntosRuta = ""

            for (i in 0 ..< rutas.length) {
                val rutaElement = rutas.item(i) as Element
                val nombreRuta = rutaElement.getElementsByTagName("nom").item(0).textContent

                if (nombreRuta == rutaSeleccionada) {
                    val puntos = rutaElement.getElementsByTagName("punt")

                    for (j in 0 ..< puntos.length) {
                        val puntoElement = puntos.item(j) as Element
                        val nombrePunto = puntoElement.getElementsByTagName("nom").item(0).textContent
                        val latitud = puntoElement.getElementsByTagName("latitud").item(0).textContent
                        val longitud = puntoElement.getElementsByTagName("longitud").item(0).textContent

                        puntosRuta += "$nombrePunto ($latitud, $longitud)\n"
                    }
                    break
                }
            }
            area.text = puntosRuta
        }
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        val finestra = Finestra()
        finestra.isVisible = true
        finestra.setLocationRelativeTo(null)
    }
}