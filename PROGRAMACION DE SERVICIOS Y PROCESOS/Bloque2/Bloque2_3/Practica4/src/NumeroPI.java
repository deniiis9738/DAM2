class Acumula {
	double suma;

	public Acumula () {
		this.suma = 0.0;
	}

	void acumulaDato ( double dato ) {
		suma+= dato;
	}

	double dameDato() {
		return suma;

	}
}

class MiHebra extends Thread {
	int     miId, numHebras;
	long    numRectangulos;
	Acumula a;

	public MiHebra ( int miId, int numHebras, long numRectangulos, Acumula a) {
		this.miId = miId;
		this.numHebras = numHebras;
		this.numRectangulos = numRectangulos;
		this.a = a;

	}

	public void run() {
		double sumaLocal = 0.0;
		for (long i = miId; i < numRectangulos; i += numHebras) {
			double x = (i + 0.5) / numRectangulos;
			sumaLocal += NumeroPI.f(x);
		}
		a.acumulaDato(sumaLocal);
	}
}



public class NumeroPI {

	public static void main(String args[]) {
		long numRectangulos;
		double baseRectangulo, x, suma, pi;
		int numHebras;
		long t1, t2;
		double tSec, tPar;

		if (args.length != 2) {
			System.out.println("Error: Número de argumentos incorrecto ");
			System.out.println("Uso : java prog <numRectangulos> ");
			System.exit(-1);
		}
		try {
			numRectangulos = Long.parseLong(args[0]);
			numHebras = Integer.parseInt(args[1]);
		} catch (NumberFormatException ex) {
			numRectangulos = -1;
			numHebras = -1;
			System.out.println("Error: Números de entrada incorrectos ");
			System.exit(-1);
		}

		System.out.println();
		System.out.println("Calculo del número PI mediante integración ");

		// Cálculo del número PI de forma secuencial
		System.out.println();
		System.out.println("Comienzo del cálculo secuencial");
		t1 = System.nanoTime();
		baseRectangulo = 1.0 / ((double) numRectangulos);
		suma = 0.0;
		for (long i = 0; i < numRectangulos; i++) {
			x = baseRectangulo * (((double) i) + 0.5);
			suma += f(x);
			//System.out.println(x);
		}
		pi = baseRectangulo * suma;
		t2 = System.nanoTime();
		tSec = ((double) (t2 - t1)) / 1.0e9;
		System.out.println("Versión Secuencial. Número PI:" + pi);
		System.out.println("Tiempo transcurrido (s.):     " + tSec);

		// Cálculo del número PI de forma cíclica
		System.out.println();
		System.out.println("Comienzo del cálculo cíclico");
		t1 = System.nanoTime();
		Acumula a = new Acumula();
		MiHebra v[] = new MiHebra[numHebras];

		for (int i = 0; i < numHebras; i++) {
			v[i] = new MiHebra(i, numHebras, numRectangulos, a);
			v[i].start();
		}

		for (int i = 0; i < numHebras; i++) {
			try {
				v[i].join();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		pi = baseRectangulo * a.dameDato();
		t2 = System.nanoTime();
		tPar = ((double) (t2 - t1)) / 1.0e9;
		System.out.println("Versión Cíclica. Número PI:" + pi);
		System.out.println("Tiempo transcurrido (s.):     " + tPar);

		System.out.println();
		System.out.println("Fin de programa");
	}

	static double f(double x) {
		return (4.0 / (1.0 + x * x));

	}
}