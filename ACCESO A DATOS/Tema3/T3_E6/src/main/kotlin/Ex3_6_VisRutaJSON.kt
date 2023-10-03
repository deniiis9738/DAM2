import javax.swing.*
import java.awt.*
import com.squareup.moshi.Moshi
import org.w3c.dom.Element
import java.io.File

class FinestraJSON : JFrame() {

    init {
        var llistaRutes = ArrayList<Ruta>()
        // sentències per a omplir llistaRutes
        val json = File("Rutes.json").readText()

        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Rutes::class.java)
        val rutes = adapter.fromJson(json)
        for (ruta in rutes?.rutes ?: emptyList()) {
            llistaRutes.add(ruta)
        }

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("JSON: Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1, BorderLayout.NORTH)
        add(panell2, BorderLayout.CENTER)

        var nomsLlistaRutes = arrayListOf<String>()
        // sentències per a omplir l'ArrayList anterior amb el nom de les rutes
        nomsLlistaRutes.add("")
        for (ruta in llistaRutes) {
            nomsLlistaRutes.add(ruta.nom)
        }

        val combo = JComboBox(nomsLlistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener {
            // accions quan s'ha seleccionat un element del combobox,
            // i que han de consistir en omplir el JTextArea
            val rutaSeleccionada = combo.getItemAt(combo.selectedIndex).toString()
            var puntosRuta = ""

            for (ruta in llistaRutes) {
                val nombreRuta = ruta.nom

                if (nombreRuta == rutaSeleccionada) {
                    val puntos = ruta.llistaDePunts

                    for (j in 0 ..< puntos.size) {
                        val nombrePunto = ruta.getPuntNom(j)
                        val latitud = ruta.getPuntLatitud(j)
                        val longitud = ruta.getPuntLongitud(j)

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
        val finestra = FinestraJSON()
        finestra.isVisible = true
        finestra.setLocationRelativeTo(null)
    }
}