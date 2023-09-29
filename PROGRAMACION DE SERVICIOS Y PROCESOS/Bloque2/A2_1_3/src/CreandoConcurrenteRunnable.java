public class CreandoConcurrenteRunnable {
    public static void main(String args[]) {
        Thread t1 = new Thread(new Tarea1R());
        Thread t2 = new Thread(new Tarea2R());

        t1.start();
        t2.start();
    }
}

class Tarea1R implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Tarea 1");
        }
    }
}

class Tarea2R implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Tarea 2");
        }
    }
}
