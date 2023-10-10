import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ViajesLocal {
    public static void main(String[] args) {
        int respuesta;
        do {
            respuesta = Menu();
        } while (respuesta == 1);
    }

    public static int Menu() {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce su código de cliente: ");
        String codcli = input.nextLine();

        System.out.println();
        System.out.println("1- Cerrar programa");
        System.out.println("2- Mostrar datos de los viajes con un origen");
        System.out.println("3- Reservar un viaje");
        System.out.println("4- Anular una reserva");
        System.out.println("5- Ofertar un nuevo viaje");
        System.out.println("6- Borrar un viaje ofertado");

        System.out.print("Indica que opción desea realizar: ");

        try{
            int respuesta = input.nextInt();
            return respuesta;
        } catch (InputMismatchException e) {
            System.out.println("El valor introducido es incorrecto");
        }
        return 0;
    }

}