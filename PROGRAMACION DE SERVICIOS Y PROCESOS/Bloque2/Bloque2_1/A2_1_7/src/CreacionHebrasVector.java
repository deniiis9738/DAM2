public class CreacionHebrasVector {

    public static void main(String[] args) {
        int numHebras = 5;
        Hebras[] hebras = new Hebras[numHebras];

        for (int i = 0; i < numHebras; i++) {
            Hebras h = new Hebras(i);
            hebras[i] = h;
            h.start();
        }

        for (int i = 0; i < hebras.length; i++) {
            try {
                hebras[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Todas las hebras han acabado");
    }
}

class Hebras extends Thread {
    int hebras;
    public Hebras(int hebras) {
        this.hebras = hebras;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hola, soy la hebra: " + hebras);
        }
    }
}