package Cliente;

import Gestor.GestorViajes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class ClienteViajes {
    public static int menu(Scanner teclado) {
        int opcion;
        System.out.println("\n\n");
        System.out.println("=====================================================");
        System.out.println("============            MENU        =================");
        System.out.println("=====================================================");
        System.out.println("0. Salir");
        System.out.println("1. Consultar viajes con un origen dado");
        System.out.println("2. Reservar un viaje");
        System.out.println("3. Anular una reserva");
        System.out.println("4. Ofertar un viaje");
        System.out.println("5. Borrar un viaje");
        do {
            System.out.print("\nElige una opcion (0..5): ");
            opcion = teclado.nextInt();
        } while ( (opcion<0) || (opcion>5) );
        teclado.nextLine(); // Elimina retorno de carro del buffer de entrada
        return opcion;
    }


    /**
     * Programa principal. Muestra el menú repetidamente y atiende las peticiones del cliente.
     *
     * @param args	no se usan argumentos de entrada al programa principal
     */
    public static void main(String[] args)  {

        Scanner teclado = new Scanner(System.in);

        // Crea un gestor de viajes
        AuxiliarClienteViajes aux = null;
        try {
            aux = new AuxiliarClienteViajes("localhost","12345");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JSONObject obj;

        System.out.print("Introduce tu codigo de cliente: ");
        String codcli = teclado.nextLine();

        int opcion;
        do {
            opcion = menu(teclado);
            switch (opcion) {
                case 0: // Guardar los datos en el fichero y salir del programa

                    // POR IMPLEMENTAR
                    aux.cierraSesion();
                    System.out.println("Cerrando sesion...");
                    break;
                case 1: { // Consultar viajes con un origen dado
                    // POR IMPLEMENTAR
                    System.out.print("Indica el origen del viaje: ");
                    String origen = teclado.nextLine();
                    JSONArray list = aux.consultaViajes(origen);
                    System.out.println(list);
                    break;
                }

                case 2: { // Reservar un viaje
                    // POR IMPLEMENTAR
                    obj = aux.reservarViaje(codcli);
                    System.out.println(obj);
                    break;
                }

                case 3: { // Anular una reserva
                    // POR IMPLEMENTAR
                    obj = aux.anulaViaje(codcli);
                    System.out.println(obj);
                    break;
                }

                case 4: { // Ofertar un viaje
                    // POR IMPLEMENTAR
                    obj = aux.ofertarViaje(codcli);
                    System.out.println(obj);
                    break;
                }

                case 5: { // Borrar un viaje ofertado
                    // POR IMPLEMENTAR
                    System.out.print("Indica el viaje que quieres borrar: ");
                    String codviaje = teclado.next();
                    obj = aux.borrarOfertaViaje(codviaje, codcli);
                    System.out.println(obj);
                    break;
                }

            } // fin switch

        } while (opcion != 0);

    } // fin de main

} // fin class