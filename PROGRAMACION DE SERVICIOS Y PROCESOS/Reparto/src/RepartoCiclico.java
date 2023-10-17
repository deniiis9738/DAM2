import java.util.Scanner;

public class RepartoCiclico {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Introduce cuantos procesos tienes: ");
        int procesos = input.nextInt();
        System.out.print("Introduce cuantas hebras tienes: ");
        int hebras = input.nextInt();
        System.out.print("¿Qué hebra deseas mostrar?: ");
        int nHebra = input.nextInt();

        for (int i = nHebra; i < procesos; i += hebras) {
            System.out.println(i);
        }
    }
}