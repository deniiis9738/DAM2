import java.util.*;

class Acumula {
	double suma;
	
	public Acumula () {
		this.suma = 0.0;
	}
	
	void acumulaDato ( double dato ) {
		suma += dato;
	}
	
	double dameDato() {
		return suma;
	}
}

class MiHebra extends Thread {
	int miId, numHebras;
	long numRectangulos;
	Acumula a;
	
	public MiHebra ( int miId, int numHebras, long numRectangulos, Acumula a) {
		this.miId = miId;
		this.numHebras = numHebras;
		this.numRectangulos = numRectangulos;
		this.a = a;
	}
	
	public void run() {
		double valor = 0;
		for ( int i = miId; i < numRectangulos; i += numHebras ) {
			NumeroPI.f(miId);
		}
		a.acumulaDato(valor);
	}
}


	

public class NumeroPI {

	public static void main ( String args[] ) {
		long 	numRectangulos;
		double 	baseRectangulo, x, suma, pi;
		// int numHebras;
		long 	t1, t2;
		double 	tSec, tPar;
		
		if ( args.length != 1 ) {
			
			System.out.println ( "Error: Número de argumentos incorrecto " );
			System.out.println ( "Uso : java prog < numRectangulos> ");
			System.exit ( -1 );
		}
		try { 
			numRectangulos = Long.parseLong( args [ 0 ] );
			// numHebras = Integer.parseInt( args [ 1 ] );
		} catch ( NumberFormatException ex ) {
			numRectangulos = -1;
			// numHebras = -1;
			System.out.println ( "Error: Numeros de entrada incorrectos " );
			System.exit ( -1 );	
		}
		
		System.out.println ();
		System.out.println ( "Calculo del numero PI mediante integracion " );
		
		//Calculo del número PI de forma secuencial
		System.out.println();
		System.out.println( "Comienzo del calculo secuencial" );
		t1 = System.nanoTime();
		baseRectangulo = 1.0 / ((double ) numRectangulos );
		suma 	       = 0.0;
		for ( long i = 0; i < numRectangulos; i++ ) {
			x= baseRectangulo * ((( double ) i ) + 0.5 );
			suma += f( x );
		}
		
		pi = baseRectangulo * suma;
		t2 = System.nanoTime();
		tSec = (( double ) ( t2 - t1 ) ) / 1.0e9;
		System.out.println ( "Version Secuencial. Numero PI:" + pi );
		System.out.println ( "Tiempo transcurrido (s.):     " + tSec );
		
		System.out.println();
		System.out.println( "Fin de programa " );
	}
	
	static double f( double x ) {
		return ( 4.0/ (1.0 + x*x ) );
	}

}