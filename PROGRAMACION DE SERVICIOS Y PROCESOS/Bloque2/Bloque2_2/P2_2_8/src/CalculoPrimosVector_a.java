
public class CalculoPrimosVector_a {
    public static void main(String args[]) {
        int numHebras;
        long vectorNumeros[] = {
                200000033L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                200000039L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                200000051L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                200000069L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                200000081L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                200000083L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                200000089L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                200000093L, 4L, 4L, 4L, 4L, 4L, 4L, 4L
        };


        numHebras = 4;

        implementacionSecuencial(vectorNumeros);

        implementacionCiclica(vectorNumeros, numHebras);

        implementacionBloques(vectorNumeros, numHebras);


    }

    static void implementacionSecuencial(long[] vectorNumeros) {
        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación secuencial.");
        int contador = 0;
        t1 = System.nanoTime();
        //Escribe aquí la implementación secuencial
        for (long v: vectorNumeros){
            if (esPrimo(v)){
                contador++;
            }
        }
        System.out.println("Hay "+contador+" números primos.");

        //Fin de la implementación secuencial
        t2 = System.nanoTime();
        tt = ((double) (t2 - t1)) / 1.0e9;

        System.out.println("Tiempo secuencial (seg.):\t\t\t" + tt);
    }

    static void implementacionCiclica(long[] vectorNumeros, int numHebras) {
        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación cíclica.");

        MiHebraCiclica v[] = new MiHebraCiclica[numHebras];

        t1 = System.nanoTime();

        for (int i = 0; i < numHebras; i++) {
            v[i] = new MiHebraCiclica(i, numHebras, vectorNumeros);
            v[i].start();
        }

        for (int i = 0; i < numHebras; i++) {
            try {
                v[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        t2 = System.nanoTime();
        tt = ((double) (t2 - t1)) / 1.0e9;

        System.out.println("Tiempo cíclico (seg.):\t\t\t" + tt);
    }


//------------------------------------------------------------------------------------------------------------

    static void implementacionBloques(long[] vectorNumeros, int numHebras) {

        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación por bloques.");

        MiHebraBloques v[] = new MiHebraBloques[numHebras];

        t1 = System.nanoTime();

        for (int i = 0; i < numHebras; i++) {
            v[i] = new MiHebraBloques(i, numHebras, vectorNumeros);
            v[i].start();
        }

        for (int i = 0; i < numHebras; i++) {
            try {
                v[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        t2 = System.nanoTime();
        tt = ((double) (t2 - t1)) / 1.0e9;

        System.out.println("Tiempo Bloques (seg.):\t\t\t" + tt);
    }

    static boolean esPrimo( long num ) {
        boolean primo;
        if( num < 2 ) {
            primo = false;
        } else {
            primo = true;
            long i = 2;
            while( ( i < num )&&( primo ) ) {
                primo = ( num % i != 0 );
                i++;
            }
        }
        return( primo );
    }
}
class MiHebraCiclica extends Thread{
    private int idHebra;
    private int numHebras;
    private long vector[];

    public MiHebraCiclica(int i, int numHebras, long vector[]){
        this.idHebra = i;
        this.numHebras = numHebras;
        this.vector = vector;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = idHebra; i < vector.length; i += numHebras) {
            long num = vector[i];
            if (CalculoPrimosVector_a.esPrimo(num)) {
                count++;
            }
        }
        System.out.println("La hebra " + idHebra + " ha encontrado " + count + " números primos");
    }
}

class MiHebraBloques extends Thread{
    private int idHebra;
    private int numHebras;
    private long vector[];

    public MiHebraBloques(int i, int numHebras, long vector[]){
        this.idHebra = i;
        this.numHebras = numHebras;
        this.vector = vector;
    }

    @Override
    public void run() {
        int size = (vector.length + numHebras - 1) / numHebras;
        int ini = idHebra * size;
        int fin = Math.min(vector.length, (idHebra + 1) * size);

        int count = 0;
        for (int i = ini; i < fin; i ++) {
            long num = vector[i];
            if (CalculoPrimosVector_a.esPrimo(num)) {
                count++;
            }
        }
        System.out.println("La hebra " + idHebra + " ha encontrado " + count + " números primos");
    }
}
