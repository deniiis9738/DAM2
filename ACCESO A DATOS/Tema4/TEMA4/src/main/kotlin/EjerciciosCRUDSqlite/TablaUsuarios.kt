package EjerciciosCRUDSqlite

import java.sql.DriverManager

private val url = "jdbc:sqlite:proveta.sqlite"
private val con = DriverManager.getConnection(url)
private val st = con.createStatement()

private fun main() {
    createTable()
    insertData()
    updateData()
    deleteData()

    st.close();
    con.close()
}

private fun createTable() {
    val sentSQL = "CREATE TABLE IF NOT EXISTS USUARIOS(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre TEXT, " +
            "user TEXT, " +
            "password TEXT, " +
            "tlf TEXT, " +
            "email TEXT " +
            ")"

    st.executeUpdate(sentSQL)
}

private fun insertData() {
    st.executeUpdate("INSERT INTO USUARIOS (nombre, user, password, tlf, email) VALUES ('Geroge', 'gerogepop', 'gatoensucasa', '123456789', 'gerogepop@gmail.com')")
    st.executeUpdate("INSERT INTO USUARIOS (nombre, user, password, tlf, email) VALUES ('Carlos', 'carloscharly', 'f1loco', '456789123', 'carloscharly@gmail.com')")
    st.executeUpdate("INSERT INTO USUARIOS (nombre, user, password, tlf, email) VALUES ('Jose', 'josevi', 'mariotoxiwonder', '789123456', 'josevi@gmail.com')")

    selectData()
    println()
}

private fun updateData() {
    st.executeUpdate("UPDATE USUARIOS SET tlf = '147258369' WHERE nombre = 'Jose'")

    selectData()
    println()
}

private fun deleteData() {
    st.executeUpdate("DELETE FROM USUARIOS WHERE nombre = 'Jose'")

    selectData()
    println()
}

private fun selectData() {
    val resultSet = st.executeQuery("SELECT * FROM USUARIOS")

    while (resultSet.next()) {
        val id = resultSet.getInt("id")
        val nombre = resultSet.getString("nombre")
        val user = resultSet.getString("user")
        val password = resultSet.getString("password")
        val tlf = resultSet.getString("tlf")
        val email = resultSet.getString("email")

        println("ID: $id, Nombre: $nombre, Usuario: $user, Contraseña: $password, Teléfono: $tlf, Email: $email")
    }
}