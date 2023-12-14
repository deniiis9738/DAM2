package org.example.dynamicwebproject.modelo;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;

public class GestorOperador {

	RandomAccessFile stream;
	HashSet<String> operaciones;

	public GestorOperador() {
		creaFichero("examen26_1.dat");
	}

	private void creaFichero(String nombreFichero) {
		try {
			boolean exists = (new File(nombreFichero)).exists();
			stream = new RandomAccessFile(nombreFichero, "rw");
			operaciones = new HashSet<>();
			if (!exists) {
				creaUsuarioPorDefecto();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el fichero: " + nombreFichero);
			System.exit(0);
		}
	}

	private void creaUsuarioPorDefecto() {
		Operador nuevoOp1 = new Operador(1, "+", "Suma", 24.0);
		nuevoOp1.escribeEnFichero(stream);
		Operador nuevoOp2 = new Operador(2, "-", "Resta", 19.0);
		nuevoOp2.escribeEnFichero(stream);
		Operador nuevoOp3 = new Operador(3, "*", "Producto", 25.0);
		nuevoOp3.escribeEnFichero(stream);
		Operador nuevoOp4 = new Operador(4, "/", "División", 27.0);
		nuevoOp4.escribeEnFichero(stream);
	}

	public void cierraGestor() {
		try {
			stream.close();
		} catch (IOException e) {
			System.out.println("No se ha podido cerrar el fichero");
		}
	}

	private void posicionaFichero(long posicion) {
		try {
			stream.seek(posicion);
		} catch (IOException e) {
			System.out.println("Error posicionando el puntero al inicio del fichero");
			System.exit(0);
		}
	}

	public String[] listaDeOperaciones() {
		return hashArray(operaciones);
	}

	private String[] hashArray(HashSet<String> users) {
		String[] lista = new String[users.size()];
		int i = 0;
		for (String val : users) lista[i++] = val;
		return lista;
	}

	public String calculaRdo(String oper, double op1, double op2) {
		double rdo = 0.0;
		switch (oper) {
			case "+":
				rdo = op1 + op2;
				break;
			case "-":
				rdo = op1 - op2;
				break;
			case "*":
				rdo = op1 * op2;
				break;
			case "/":
				if (op2 != 0) {
					rdo = op1 / op2;
				} else {
					return "Error: División por cero.";
				}
				break;
			default:
				return "Operación no válida.";
		}
		return Double.toString(rdo);
	}

	public String mostrarOperacion(String oper) {
		return "Operación: " + oper;
	}
}
