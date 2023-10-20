public class SinReducciones {
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
        AcumulaSin a = new AcumulaSin();
        MiHebraSin v[] = new MiHebraSin[numHebras];
        t1 = System.nanoTime();

        for (int i = 0; i < numHebras; i++) {
            v[i] = new MiHebraSin(i, numHebras, vectorNumeros, a);
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

class MiHebraSin extends Thread {
    int miId, numHebras;
    double vector [ ];
    AcumulaSin a;

    public MiHebraSin ( int miId, int numHebras, double vector [ ], AcumulaSin a ) {
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

class AcumulaSin {
    double suma = 0.0;

    synchronized void acumulaValor ( double valor ) {
        this.suma += valor;
    }

    synchronized double dameResultado() {
        return this.suma;
    }
}