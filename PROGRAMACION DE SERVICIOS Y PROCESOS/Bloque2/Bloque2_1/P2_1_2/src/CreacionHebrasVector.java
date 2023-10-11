public class CreacionHebrasVector {

    public static void main(String[] args) {
        int numHebras = 4;
        Hebras[] hebras = new Hebras[numHebras];
        CuentaIncrementos cuentaIncrementos = new CuentaIncrementos();
        System.out.println("Empiezan");

        for (int i = 0; i < numHebras; i++) {
            Hebras h = new Hebras(i, cuentaIncrementos);
            hebras[i] = h;
            h.start();
        }

        for (int i = 0; i < numHebras; i++) {
            try {
                hebras[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Terminado");
        System.out.println("Contador: " + cuentaIncrementos.dameContador());
    }
}

class Hebras extends Thread {
    int hebras;
    CuentaIncrementos cuentaIncrementos;

    public Hebras(int hebras, CuentaIncrementos cuentaIncrementos) {
        this.hebras = hebras;
        this.cuentaIncrementos = cuentaIncrementos;
    }

    public void run() {
        for (int i = 0; i < 1000000; i++) {
            cuentaIncrementos.incrementaContador();
        }
    }
}