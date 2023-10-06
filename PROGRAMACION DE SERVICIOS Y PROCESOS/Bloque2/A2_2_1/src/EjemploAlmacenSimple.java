public class EjemploAlmacenSimple {
    volatile int dato = 0;

    void fijaDato(int dato) {
        this.dato = dato;
    }

    int dameDato() {
        return this.dato;
    }

    public static void main(String[] args) {
        EjemploAlmacenSimple ejemploAlmacenSimple = new EjemploAlmacenSimple();
        ejemploAlmacenSimple.fijaDato(5);
        System.out.println(ejemploAlmacenSimple.dameDato());
    }
}