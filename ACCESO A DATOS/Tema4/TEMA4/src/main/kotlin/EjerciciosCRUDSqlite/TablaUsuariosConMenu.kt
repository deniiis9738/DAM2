package EjerciciosCRUDSqlite

import java.sql.DriverManager
import java.util.Scanner
import kotlin.system.exitProcess

private val url = "jdbc:sqlite:proveta.sqlite"
private val con = DriverManager.getConnection(url)
private val st = con.createStatement()

fun main() {
    menu()

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

    try {
        st.executeUpdate(sentSQL)
    } catch (e: Exception) {
        println("La tabla ya existe")
    }
}

private fun insertData() {
    try {
        st.executeUpdate("INSERT INTO USUARIOS (nombre, user, password, tlf, email) VALUES ('Geroge', 'gerogepop', 'gatoensucasa', '123456789', 'gerogepop@gmail.com')")
        st.executeUpdate("INSERT INTO USUARIOS (nombre, user, password, tlf, email) VALUES ('Carlos', 'carloscharly', 'f1loco', '456789123', 'carloscharly@gmail.com')")
        st.executeUpdate("INSERT INTO USUARIOS (nombre, user, password, tlf, email) VALUES ('Jose', 'josevi', 'mariotoxiwonder', '789123456', 'josevi@gmail.com')")

        selectData()
        println()
    } catch (e: Exception) {
        println("No se han podido introducir los datos")
        println()
    }
}

private fun updateData() {
    try {
        st.executeUpdate("UPDATE USUARIOS SET tlf = '147258369' WHERE nombre = 'Jose'")

        selectData()
        println()
    } catch (e: Exception) {
        println("No se han podido actualizar los datos")
        println()
    }
}

private fun deleteData() {
    try {
        st.executeUpdate("DELETE FROM USUARIOS WHERE nombre = 'Jose'")

        selectData()
        println()
    } catch (e: Exception) {
        println("No se han podido borrar los datos")
        println()
    }
}

private fun deleteAllData() {
    try {
        st.executeUpdate("DELETE FROM USUARIOS")

        selectData()
        println()
    } catch (e: Exception) {
        println("No se han podido borrar todos los datos")
        println()
    }
}

private fun selectData() {
    try {
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
    } catch(e: Exception) {
        println("No se ha podido mostrar los datos")
        println()
    }
}

private fun menu() {
    val input = Scanner(System.`in`)

    do {
        println()
        println("0- CERRAR PROGRAMA")
        println("1- INSERTAR DATOS.")
        println("2- ACTUALIZAR DATOS.")
        println("3- BORRAR DATOS.")
        println("4- BORRAR TODOS LOS DATOS.")
        println("5- CREAR TABLA.")
        println("6- MOSTRAR DATOS.")
        println()
        print("Introduce la opción que deseas realizar: ")
        val opcion = input.nextInt()

        when(opcion) {
            0 -> exitProcess(0)
            1 -> insertData()
            2 -> updateData()
            3 -> deleteData()
            4 -> deleteAllData()
            5 -> createTable()
            6 -> selectData()
            else -> {
                print("Opción introducida incorrectamente, vuelva a introducirla: ")
                println()
            }
        }
    } while (opcion != 0)
}