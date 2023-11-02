package Postgres;

import java.sql.*;

public class EjemploDeStoredProcedureUsuariosMasDeUnCampo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://172.17.0.2:5432/postgres";
        String usuario = "postgres";
        String password = "secret";
        Connection con = DriverManager.getConnection(url, usuario, password);

        PreparedStatement pStmt = con.prepareStatement(
                "select listaPrsonas(?)"
        );
        pStmt.setString(1, "G%");
        ResultSet rs = pStmt.executeQuery();

        while (rs.next()) {
            System.out.println("Datos: " + rs.getString(1));
        }
        rs.close();
        con.close();
    }
}
