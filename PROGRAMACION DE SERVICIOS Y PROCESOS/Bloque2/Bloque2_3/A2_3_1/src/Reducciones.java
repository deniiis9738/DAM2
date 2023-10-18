public class Reducciones {
    public static void main(String args[]) {
        int numHebras;
        double vectorNumeros[] = new double[10000000];
        long t1;
        long t2;
        double tt;

        for (int i = 0; i < vectorNumeros.length; i++) {
            vectorNumeros[i] = i;
        }

        numHebras = 4;
        Acumula a = new Acumula();
        MiHebra v[] = new MiHebra[numHebras];
        t1 = System.nanoTime();

        for (int i = 0; i < numHebras; i++) {
            v[i] = new MiHebra(i, numHebras, vectorNumeros, a);
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

        System.out.println(a.dameResultado());
        System.out.println("Tiempo cíclico (seg.):\t\t\t" + tt);
    }
}

class MiHebra extends Thread {
    int miId, numHebras;
    double vector [ ];
    Acumula a;

    public MiHebra ( int miId, int numHebras, double vector [ ], Acumula a ) {
        this.miId = miId;
        this.numHebras = numHebras;
        this.vector = vector;
        this.a = a;
    }

    public void run () {
        for ( int i = miId; i < vector.length; i += numHebras ) {
            a.acumulaValor ( vector [ i ] );
        }
    }
}

class Acumula {
    double suma = 0.0;

    synchronized void acumulaValor ( double valor ) {
        this.suma += valor;
    }

    synchronized double dameResultado() {
        return this.suma;
    }
}