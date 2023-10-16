import javax.swing.*
import java.awt.*
import org.json.JSONTokener
import org.json.JSONObject
import org.json.JSONArray
import java.net.URL

class FinestraBicicas : JFrame() {
    var estacions = JSONArray()
    var listModel = DefaultListModel<String>()
    var list = JList(listModel)
    var area = JTextArea(5, 15)

    init {

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("JSON: Vista detallada BICICAS")
        setSize(800, 800)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(GridLayout(1, 2))
        add(panell1, BorderLayout.NORTH)
        add(panell2, BorderLayout.CENTER)
        list.setForeground(Color.blue)
        var scroll1 = JScrollPane(list)
        var scroll2 = JScrollPane(area)
        panell2.add(scroll1)
        panell2.add(scroll2)

        panell1.add(JLabel("LListat actual BICICAS"))

        agafarBicicas()

        mostrarEstacions()

        list.addListSelectionListener() {
            if (list.getSelectedIndex() >= 0)
                visualitzaEstacio(list.getSelectedIndex())
        }
    }

    fun agafarBicicas() {
        // Instruccions per a llegir de la pàgina de Bicicas i col·locar en arrel
        val bicicas = URL("http://gestiona.bicicas.es/apps/apps.php");
        val arrel = (JSONTokener(bicicas.openConnection().getInputStream()).nextValue() as JSONArray).get(0) as JSONObject
        // Instruccions per a col·locar les estacions en estacions (JsonArray)
        estacions = arrel.getJSONArray("ocupacion")
    }

    fun mostrarEstacions() {
        // Instruccions per a introduir en el JList les estacions
        // La manera d'anar introduint informació en el JList és a través del DefaultListModel:
        // listModel.addElement("Linia que es vol introduir ")
        for (i in 0 ..< estacions.length()) {
            val estacio = estacions.getJSONObject(i)
            val numEstacio = estacio.getInt("id")
            val nomEstacio = estacio.getString("punto")
            val puestos = estacio.getInt("puestos")
            val ocupats = estacio.getInt("ocupados")

            val text = "$numEstacio.- $nomEstacio ($ocupats/$puestos)"
            listModel.addElement(text)
        }
    }

    fun visualitzaEstacio(numEst: Int) {
        // Instruccions per a mostrar les característiques en el area, el JTextArea de la dreta anomenat area
        if (numEst in 0 until estacions.length()) {
            val estacio = estacions.getJSONObject(numEst)
            val idEstacio = estacio.getString("id")
            val nomEstacio = estacio.getString("punto")
            val puestos = estacio.getInt("puestos")
            val ocupados = estacio.getInt("ocupados")
            val latitud = estacio.getFloat("latitud")
            val longitud = estacio.getFloat("longitud")
            val porcentajeAltaOcupacion = estacio.getInt("porcentajeAltaOcupacion")
            val porcentajeBajaOcupacion = estacio.getInt("porcentajeBajaOcupacion")

            val informacioEstacio = "$idEstacio - $nomEstacio\n\n" +
                    "Número estació: $idEstacio\n" +
                    "Nom estació: $nomEstacio\n" +
                    "Posicions: $puestos\n" +
                    "Posicions ocupades: $ocupados\n" +
                    "Latitud: $latitud\n" +
                    "Longitud: $longitud\n" +
                    "Percentatge alta ocupació: $porcentajeAltaOcupacion\n" +
                    "Percentathe baixa ocupació: $porcentajeBajaOcupacion"
            area.text = informacioEstacio
        }
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        FinestraBicicas().isVisible = true
    }
}