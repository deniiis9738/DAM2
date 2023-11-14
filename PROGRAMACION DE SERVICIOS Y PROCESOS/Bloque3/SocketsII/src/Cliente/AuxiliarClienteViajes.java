package Cliente;

import Comun.MyStreamSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import Gestor.GestorViajes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Esta clase es un módulo que proporciona la logica de aplicacion
 * para el Cliente del sevicio de viajes usando sockets de tipo stream
 */

public class AuxiliarClienteViajes {
    static Scanner input = new Scanner(System.in);

    private final MyStreamSocket mySocket; // Socket de datos para comunicarse con el servidor
    JSONParser parser;

    /**
     * Construye un objeto auxiliar asociado a un cliente del servicio.
     * Crea un socket para conectar con el servidor.
     * @param	hostName	nombre de la maquina que ejecuta el servidor
     * @param	portNum		numero de puerto asociado al servicio en el servidor
     */
    AuxiliarClienteViajes(String hostName, String portNum)
            throws SocketException, UnknownHostException, IOException {

        // IP del servidor
        InetAddress serverHost = InetAddress.getByName(hostName);
        // Puerto asociado al servicio en el servidor
        int serverPort = Integer.parseInt(portNum);
        //Instantiates a stream-mode socket and wait for a connection.
        this.mySocket = new MyStreamSocket(serverHost, serverPort);
        /**/  System.out.println("Hecha peticion de conexion");
        parser = new JSONParser();
    } // end constructor

    /**
     * Devuelve los viajes ofertados desde un origen dado
     *
     * @param origen	origen del viaje ofertado
     * @return array JSON de viajes desde un origen. array vacio si no hay ninguno
     */
    public JSONArray consultaViajes(String origen) {
        // POR IMPLEMENTAR
        JSONObject consulta = new JSONObject();
        consulta.put("peticion", 1);
        consulta.put("origen", origen);

        String respuesta;
        JSONArray array = new JSONArray();
        try {
            mySocket.sendMessage(consulta.toJSONString());
            respuesta = mySocket.receiveMessage();
            array = (JSONArray) parser.parse(respuesta);
        } catch (Exception e) { e.printStackTrace(); }

        return array; // cambiar por el retorno correcto
    } // end consultaViajes



    /**
     * Un pasajero reserva un viaje
     *
     * @param gestorViajes		gestor del viaje
     * @param codcli	codigo del pasajero
     * @return	objeto JSON con los datos del viaje. Vacio si no se ha podido reservar
     */
    public static void reservarViaje(GestorViajes gestorViajes, String codcli) {
        System.out.print("Introduce el código del viaje a reservar: ");
        String codviaje = input.next();
        System.out.println();
        gestorViajes.reservaViaje(codviaje, codcli);
        gestorViajes.guardaDatos();
    }

    /**
     * Un pasajero anula una reserva
     *
     * @param gestorViajes		objeto gestor viajes
     * @param codcli	codigo del cliente
     * @return	objeto JSON con los datos del viaje. Vacio si no se ha podido reservar
     */
    public static void anulaViaje(GestorViajes gestorViajes, String codcli) {
        System.out.print("Introduce el código del viaje a anular: ");
        String codviaje = input.next();
        System.out.println();
        gestorViajes.anulaReserva(codviaje, codcli);
        gestorViajes.guardaDatos();
    }

    /**
     * Un cliente oferta un nuevo viaje
     *
     * @param gestorViajes		objeto gestor viajes
     * @param codcli	codigo del cliente
     * @return	viaje ofertado en formatoJSON. Vacio si no se ha podido ofertar
     */
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

    /**
     * Un cliente borra una oferta de viaje
     *
     * @param gestorViajes		gestor del viaje
     * @param codcli	codigo del pasajero
     * @return	objeto JSON con los datos del viaje. Vacio si no se ha podido reservar
     */
    public static void borrarOfertaViaje(GestorViajes gestorViajes, String codcli) {
        System.out.println();
        gestorViajes.borrarViaje(codcli);
        gestorViajes.guardaDatos();
    }

    /**
     * Finaliza la conexion con el servidor
     */
    public void cierraSesion( ) {
        // POR IMPLEMENTAR
        System.exit(0);
    } // end done
} //end class