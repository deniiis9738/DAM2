import java.util.InputMismatchException;
import java.util.Scanner;

public class ViajesLocal {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Introduce su código de cliente: ");
        String codcli = input.nextLine();
        GestorViajes gestorViajes = new GestorViajes();
        int respuesta;
        do {
            respuesta = Menu();
            switch (respuesta) {
                case 1:
                    finalizarPrograma();
                    break;
                case 2:
                    mostrarDatosViajeOrigen(gestorViajes);
                    break;
                case 3:
                    reservarViaje(gestorViajes, codcli);
                    break;
                case 4:
                    anulaViaje(gestorViajes, codcli);
                    break;
                case 5:
                    ofertarViaje(gestorViajes, codcli);
                    break;
                case 6:
                    borrarOfertaViaje(gestorViajes, codcli);
                    break;
            }
        } while (respuesta != 1);
    }

    public static int Menu() {
        System.out.println();
        System.out.println("1- Cerrar programa");
        System.out.println("2- Mostrar datos de los viajes con un origen");
        System.out.println("3- Reservar un viaje");
        System.out.println("4- Anular una reserva");
        System.out.println("5- Ofertar un nuevo viaje");
        System.out.println("6- Borrar un viaje ofertado");
        System.out.println();
        System.out.print("Indica que opción desea realizar: ");

        try{
            int respuesta = input.nextInt();
            System.out.println();
            return respuesta;
        } catch (InputMismatchException e) {
            System.out.println("El valor introducido es incorrecto");
            return 1;
        }

    }

    public static void mostrarDatosViajeOrigen(GestorViajes gestorViajes) {
        System.out.print("Introduce el origen a consultar: ");
        String origen = input.next();
        System.out.println();
        System.out.println(gestorViajes.consultaViajes(origen));
    }

    public static void finalizarPrograma() {
        System.out.println("Programa finalizado");
    }

    public static void reservarViaje(GestorViajes gestorViajes, String codcli) {
        System.out.print("Introduce el código del viaje a reservar: ");
        String codviaje = input.next();
        System.out.println();
        gestorViajes.reservaViaje(codviaje, codcli);
        gestorViajes.guardaDatos();
    }

    public static void anulaViaje(GestorViajes gestorViajes, String codcli) {
        System.out.print("Introduce el código del viaje a anular: ");
        String codviaje = input.next();
        System.out.println();
        gestorViajes.anulaReserva(codviaje, codcli);
        gestorViajes.guardaDatos();
    }

    public static void ofertarViaje(GestorViajes gestorViajes, String codcli) {
        System.out.print("Introduce el origen del viaje: ");
        String origen = input.next();
        System.out.print("Introduce el destino del viaje: ");
        String destino = input.next();
        System.out.print("Introduce la fecha del viaje: ");
        String fecha = input.next();
        System.out.print("Introduce el precio del viaje: ");
        long precio = input.nextLong();
        System.out.print("Introduce el número máximo de plazas del viaje: ");
        long numplazas = input.nextLong();
        System.out.println();
        gestorViajes.ofertaViaje(codcli, origen, destino, fecha, precio, numplazas);
        gestorViajes.guardaDatos();
    }

    public static void borrarOfertaViaje(GestorViajes gestorViajes, String codcli) {
        System.out.println();
        gestorViajes.borrarViaje(codcli);
        gestorViajes.guardaDatos();
    }
}