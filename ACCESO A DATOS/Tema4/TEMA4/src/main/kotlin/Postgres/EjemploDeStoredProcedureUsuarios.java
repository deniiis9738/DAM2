package Postgres;

import java.sql.*;

public class EjemploDeStoredProcedureUsuarios {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://172.17.0.2:5432/postgres";
        String usuario = "postgres";
        String password = "secret";
        Connection con = DriverManager.getConnection(url, usuario, password);

        CallableStatement cStmt = con.prepareCall("{? = call CantidadTotalPersonas()}");
        cStmt.registerOutParameter(1, Types.INTEGER);

        cStmt.execute();
        int resultado = cStmt.getInt(1);
        System.out.println("Resultado: " + resultado);
        con.close();
    }
}
