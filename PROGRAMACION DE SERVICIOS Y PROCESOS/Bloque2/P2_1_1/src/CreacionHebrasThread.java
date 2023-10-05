public class CreacionHebrasThread {
    public static void main(String[] args) {
        Tarea1 t1 = new Tarea1(0);
        Tarea1 t2 = new Tarea1(1);

        t1.start();
        t2.start();
    }
}

class Tarea1 extends Thread {
    private int idHebra;
    public Tarea1 (int idHebra){
        this.idHebra = idHebra;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(idHebra);
        }
    }
}