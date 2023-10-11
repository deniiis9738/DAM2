public class EjemploSincro {
    int numServicios = 0;

    synchronized void incrementaNumServicios() {
        numServicios++;
    }

    synchronized int dameNumServicios() {
        return numServicios;
    }
}
