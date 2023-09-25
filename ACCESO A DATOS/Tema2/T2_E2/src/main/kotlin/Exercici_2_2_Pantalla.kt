import javax.swing.*
import java.awt.*
import java.io.File
import java.io.FileInputStream
import java.io.FileWriter

class Exercici_2_2_Pantalla : JFrame() {
	val et_f = JLabel("Fitxer:")
	val fitxer = JTextField(25)
	val obrir = JButton("Obrir")
	val guardar = JButton("Guardar")
	val et_a = JLabel("Contingut:")
	val area = JTextArea(10, 50)
	val scrollPane = JScrollPane(area)

	// en iniciar posem un contenidor per als elements anteriors
	init {
		defaultCloseOperation = JFrame.EXIT_ON_CLOSE

		setLayout(GridLayout(2, 1))
		setTitle("Editor de text")

		val panell1 = JPanel(GridLayout(0, 1))
		val panell1_1 = JPanel(FlowLayout())
		panell1.add(panell1_1)
		panell1_1.add(et_f)
		panell1_1.add(fitxer)

		val panell1_2 = JPanel(FlowLayout())
		panell1.add(panell1_2)
		panell1_2.add(obrir)
		panell1_2.add(guardar)
		val panell2 = JPanel(GridLayout(0, 1))
		panell2.add(scrollPane)
		area.setEditable(true)

		add(panell1)
		add(panell2)
		pack()
		
		obrir.addActionListener {
		// Instruccions per a bolcar el contingut del fitxer en el JTextArea
			if (File(fitxer.getText()).exists()) {
				val f = File(fitxer.getText())
				val f_in = FileInputStream(f)

				var c = f_in.read()
				while (c != -1) {
					area.append(c.toChar().toString())
					c = f_in.read()
				}
				f_in.close()
			} else {
				println("El fichero o ruta indicada no existe")
			}
		}
		
		guardar.addActionListener {
		// Instruccions per a guardar el contingut del JTextArea al fitxer.
			val f = File(fitxer.getText())
			val textArea = area.getText()
			val f_out = FileWriter(f)

			for (c in textArea) {
				f_out.write(c.toString())
			}
			f_out.close()
		}
	}
}

private fun crearMostrarFinestra() {

	val frame = Exercici_2_2_Pantalla()
	frame.isVisible = true
}

fun main(args: Array<String>) {
	EventQueue.invokeLater(::crearMostrarFinestra)
}

