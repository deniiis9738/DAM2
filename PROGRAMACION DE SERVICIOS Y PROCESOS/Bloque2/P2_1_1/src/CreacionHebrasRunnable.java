public class CreacionHebrasRunnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Tarea1R(0));
        Thread t2 = new Thread(new Tarea1R(1));

        t1.start();
        t2.start();
    }
}

class Tarea1R implements Runnable {
    int idHebra;

    public Tarea1R (int idHebra) {
        this.idHebra = idHebra;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(idHebra);
        }
    }
}