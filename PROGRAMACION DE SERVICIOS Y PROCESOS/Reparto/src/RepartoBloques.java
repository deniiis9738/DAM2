import java.util.Scanner;

public class RepartoBloques {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Introduce cuantos procesos tienes: ");
        int procesos = input.nextInt();
        System.out.print("Introduce cuantas hebras tienes: ");
        int hebras = input.nextInt();
        System.out.println("¿Qué hebra quieres imprimir?");
        int hebraIndicada = input.nextInt();

        int size = (procesos+hebras-1)/hebras;
        int ini = hebraIndicada*size;
        int fin = Math.min(procesos,(hebraIndicada+1)*size);

        for (int i= ini; i < fin; i++){
            System.out.println(i);
        }
    }
}