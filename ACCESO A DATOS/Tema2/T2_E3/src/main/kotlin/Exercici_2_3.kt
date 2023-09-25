package exercicis

import javax.swing.*
import java.awt.*
import java.io.File
import java.io.FileInputStream
import java.io.FileWriter
import java.nio.charset.Charset

class Exercici_2_3 : JFrame() {
    val area = JTextArea()
    val scrollPane = JScrollPane(area)

    val menu_p = JMenuBar()

    val menu_arxiu = JMenu("Arxiu")
    val menu_ajuda = JMenu("Ajuda")

    val obrir = JMenuItem("Obrir")
    val guardar = JMenuItem("Guardar")
    val guardarCom = JMenuItem("Guardar com ...")
    val eixir = JMenuItem("Eixir")

    val quantA = JMenuItem("Quant a Editor")

    val codificacion = JComboBox(arrayOf("UTF-8", "ISO-8859-15"))

    var f = File("")

    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        setLayout(BorderLayout())
        setTitle("Editor de text més avançat")
        add(scrollPane)
        add(codificacion, BorderLayout.SOUTH)
        area.setEditable(true)

        setSize(750, 400)
        setJMenuBar(menu_p)

        menu_p.add(menu_arxiu)
        menu_p.add(menu_ajuda)
        menu_arxiu.add(obrir)
        menu_arxiu.add(guardar)
        menu_arxiu.add(guardarCom)
        menu_arxiu.add(JSeparator())
        menu_arxiu.add(eixir)

        menu_ajuda.add(quantA);

        obrir.addActionListener { obrir() }

        guardar.addActionListener { guardar() }

        guardarCom.addActionListener { guardarCom() }

        eixir.addActionListener { eixir() }

        quantA.addActionListener { quantA() }

        codificacion.addActionListener { cambiarCodificacion() }
    }

    fun obrir() {
        // Instruccions per a obrir un fitxer i posar el contingut en el JTextArea
        val fileChooser = JFileChooser()
        val result = fileChooser.showOpenDialog(null)

        if (result == JFileChooser.APPROVE_OPTION) {
            f = fileChooser.selectedFile
            val f_in = FileInputStream(f)

            var c = f_in.read()
            while (c != -1) {
                area.append(c.toChar().toString())
                c = f_in.read()
            }
            f_in.close()
        } else {
            println("No se ha escogido ningún archivo.")
        }
    }

    fun guardar() {
        // Instruccions per a guardar el contingut del JTextArea al fitxer.
        val textArea = area.getText()
        val f_out = FileWriter(f)

        for (c in textArea) {
            f_out.write(c.toString())
        }
        f_out.close()
    }

    fun guardarCom() {
        // Instruccions per a guardar el contingut del JTextArea al fitxer, amb la possibilitat de canviar el nom
        val saveChooser = JFileChooser()
        val result = saveChooser.showOpenDialog(null)

        if (result == JFileChooser.APPROVE_OPTION) {
            f = saveChooser.selectedFile
            val textArea = area.getText()
            val f_out = FileWriter(f)

            for (c in textArea) {
                f_out.write(c.toString())
            }

            f_out.close()
        } else {
            println("No se ha escogido ningún archivo.")
        }
    }

    fun eixir() {
        // Instruccions per a eixir
        System.exit(0)
    }

    fun quantA() {
        // Instruccions per a mostrar un diàleg amb la versió (Acerca de...)
        JOptionPane.showMessageDialog(this, "Esta es la versión 1.0.0", "Versión del programa",
            JOptionPane.INFORMATION_MESSAGE)
    }

    fun cambiarCodificacion() {
        //No se hacerlo
    }
}


fun main(args: Array<String>) {
    EventQueue.invokeLater( { Exercici_2_3().isVisible = true })
}

