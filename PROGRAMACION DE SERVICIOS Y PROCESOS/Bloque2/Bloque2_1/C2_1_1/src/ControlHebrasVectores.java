public class ControlHebrasVectores {

    public static void main(String[] args) {
        int numHebras = 100;
        Hebras[] hebras = new Hebras[numHebras];

        System.out.println("Hebras divisibles entre 3 y 5:");
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
        System.out.println("El resultado ha terminado");
    }
}

class Hebras extends Thread {
    int hebras;
    public Hebras(int hebras) {
        this.hebras = hebras;
    }

    public void run() {
        if (hebras % 15 == 0) {
            System.out.println(hebras);
        }
    }
}