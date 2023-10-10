import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Scanner;

public class GestorViajes {
    private static FileWriter os;            // stream para escribir los datos en el fichero
    private static FileReader is;            // stream para leer los datos del fichero

    /**
     * Diccionario para manejar los datos en memoria.
     * La clave es el codigo único del viaje.
     */
    private static HashMap<String, Viaje> mapa;


    /**
     * Constructor del gestor de viajes
     * Crea o Lee un fichero con datos de prueba
     */
    public GestorViajes() {
        mapa = new HashMap<String, Viaje>();
        File file = new File("viajes.json");
        try {
            if (!file.exists()) {
                // Si no existe el fichero de datos, los genera y escribe
                os = new FileWriter(file);
                generaDatos();
                escribeFichero(os);
                os.close();
            }
            // Si existe el fichero o lo acaba de crear, lo lee y rellena el diccionario con los datos
            is = new FileReader(file);
            leeFichero(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Cuando cada cliente cierra su sesion volcamos los datos en el fichero para mantenerlos actualizados
     */
    public void guardaDatos() {
        File file = new File("viajes.json");
        try {
            os = new FileWriter(file);
            escribeFichero(os);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Escribe en el fichero un array JSON con los datos de los viajes guardados en el diccionario
     *
     * @param os stream de escritura asociado al fichero de datos
     */
    private void escribeFichero(FileWriter os) {
        // POR IMPLEMENTAR
        JSONArray jsonArray = new JSONArray();
        JSONArray raiz = new JSONArray();
        for (String codigo : mapa.keySet()) {
            jsonArray.add(mapa.get(codigo).getCodviaje());
            JSONObject viaje = mapa.get(codigo).toJSON();
            raiz.add(viaje);
        }

        try {
            os.write(raiz.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Genera los datos iniciales
     */
    private void generaDatos() {
        Viaje viaje = new Viaje("pedro", "Castellón", "Alicante", "28-05-2024", 16, 1);
        mapa.put(viaje.getCodviaje(), viaje);

        viaje = new Viaje("pedro", "Alicante", "Castellón", "29-05-2024", 16, 1);
        mapa.put(viaje.getCodviaje(), viaje);

        viaje = new Viaje("maria", "Madrid", "Valencia", "07-06-2024", 7, 2);
        mapa.put(viaje.getCodviaje(), viaje);

        viaje = new Viaje("carmen", "Sevilla", "Barcelona", "12-08-2024", 64, 1);
        mapa.put(viaje.getCodviaje(), viaje);

        viaje = new Viaje("juan", "Castellón", "Cordoba", "07-11-2024", 39, 3);
        mapa.put(viaje.getCodviaje(), viaje);
    }

    /**
     * Lee los datos del fichero en formato JSON y los añade al diccionario en memoria
     *
     * @param is stream de lectura de los datos del fichero
     */
    private void leeFichero(FileReader is) {
        JSONParser parser = new JSONParser();
        try {
            // Leemos toda la información del fichero en un array de objetos JSON
            org.json.simple.JSONArray array = (org.json.simple.JSONArray) parser.parse(is);
            // Rellena los datos del diccionario en memoria a partir del JSONArray
            rellenaDiccionario(array);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * Rellena el diccionario a partir de los datos en un JSONArray
     *
     * @param array JSONArray con los datos de los Viajes
     */
    private void rellenaDiccionario(org.json.simple.JSONArray array) {
        for (Object obj : array) {
            JSONObject jsonViaje = (JSONObject) obj;

            String codviaje = (String) jsonViaje.get("codviaje");
            String codprop = (String) jsonViaje.get("codprop");
            String origen = (String) jsonViaje.get("origen");
            String destino = (String) jsonViaje.get("destino");
            String fecha = (String) jsonViaje.get("fecha");
            int precio = ((Long) jsonViaje.get("precio")).intValue();
            int numplazas = ((Long) jsonViaje.get("numplazas")).intValue();

            Viaje viaje = new Viaje(codprop, origen, destino, fecha, precio, numplazas);
            mapa.put(codviaje, viaje);
        }
    }


    /**
     * Devuelve los viajes disponibles con un origen dado
     *
     * @param origen
     * @return JSONArray de viajes con un origen dado. Vacío si no hay viajes disponibles con ese origen
     */
    public JSONArray consultaViajes(String origen) {
        JSONArray arrayViajesOrigen = new JSONArray();

        for (String cod : mapa.keySet()) {
            if (mapa.get(cod).getOrigen().equals(origen)) {
                arrayViajesOrigen.add(mapa.get(cod));
            }
        }
        return arrayViajesOrigen;
    }

    /**
     * El cliente codcli reserva el viaje codviaje
     *
     * @param codviaje
     * @param codcli
     * @return JSONObject con la información del viaje. Vacío si no existe o no está disponible
     */
    public JSONObject reservaViaje (String codviaje, String codcli){
        for (String cod : mapa.keySet()) {
            if (mapa.get(cod).getCodviaje().equals(codviaje)) {
                if (mapa.get(cod).quedanPlazas()) {
                    mapa.get(cod).anyadePasajero(codcli);
                    return mapa.get(cod).toJSON();
                }
            }
        }
        return null;
    }

    /**
     * El cliente codcli anula su reserva del viaje codviaje
     *
     * @param codviaje    codigo del viaje a anular
     * @param codcli    codigo del cliente
     * @return JSON del viaje en que se ha anulado la reserva. JSON vacio si no se ha anulado
     */
    public JSONObject anulaReserva (String codviaje, String codcli){
        for (String cod : mapa.keySet()) {
            if (mapa.get(cod).getCodviaje().equals(codviaje)) {
                if (mapa.get(cod).quedanPlazas()) {
                    mapa.get(cod).borraPasajero(codcli);
                    return mapa.get(cod).toJSON();
                }
            }
        }
        return null;
    }

    /**
     * Devuelve si una fecha es válida y futura
     * @param fecha
     * @return
     */
    private boolean es_fecha_valida (String fecha){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            LocalDate dia = LocalDate.parse(fecha, formatter);
            LocalDate hoy = LocalDate.now();

            return dia.isAfter(hoy);
        } catch (DateTimeParseException e) {
            System.out.println("Fecha invalida: " + fecha);
            return false;
        }
    }

    /**
     * El cliente codcli oferta un Viaje
     * @param codcli
     * @param origen
     * @param destino
     * @param fecha
     * @param precio
     * @param numplazas
     * @return JSONObject con los datos del viaje ofertado
     */
    public JSONObject ofertaViaje (String codcli, String origen, String destino, String fecha,long precio, long numplazas){
        Viaje nuevoViaje = new Viaje(codcli, origen, destino, fecha, precio, numplazas);
        mapa.put(nuevoViaje.getCodprop(), nuevoViaje);
        return nuevoViaje.toJSON();
    }

    /**
     * El cliente propietario codprop elimina un Viaje ofertado
     * @param codprop
     */
    public void borrarViaje (String codprop) {
        if (mapa.get(codprop).getCodprop().equals(codprop)) {
            mapa.remove(codprop);
        }
    }
}