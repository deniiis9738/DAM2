package EjerciciosCRUDSqlite

import java.sql.DriverManager
import java.util.*
import kotlin.system.exitProcess

val input = Scanner(System.`in`)
private val url = "jdbc:sqlite:proveta.sqlite"
private val con = DriverManager.getConnection(url)
private val st = con.createStatement()

fun main() {
    menu()

    st.close();
    con.close()
}

private fun createTable() {
    val sentSQL = "CREATE TABLE USUARIOS(" +
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

private fun updateData(id: Int, nombre: String, password: String) {
    try {
        val updateNombreSQL = "UPDATE USUARIOS SET nombre = ? WHERE id = ?"
        val updatePasswordSQL = "UPDATE USUARIOS SET password = ? WHERE id = ?"

        var psNombre = con.prepareStatement(updateNombreSQL)
        var psPassword = con.prepareStatement(updatePasswordSQL)
        psNombre.setString(1, nombre);
        psNombre.setInt(2, id);

        psPassword.setString(1, password);
        psPassword.setInt(2, id);

        selectData()
        println()
    } catch (e: Exception) {
        println("No se han podido actualizar los datos")
        println()
    }
}

private fun menuUpdateData() {
    println()
    print("INTRODUCE EL ID QUE QUIERES MODIFICAR: .")
    val id = input.next()
    print("INTRODUCE EL NUEVO NOMBRE: .")
    val nuevoNombre =  input.next()
    print("INTRODUCE LA NUEVA CONTRASEÑA: .")
    val nuevaContrasenia = input.next()
    println()

    
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
        var contador = 0

        while (resultSet.next()) {
            val id = resultSet.getInt("id")
            val nombre = resultSet.getString("nombre")
            val user = resultSet.getString("user")
            val password = resultSet.getString("password")
            val tlf = resultSet.getString("tlf")
            val email = resultSet.getString("email")
            contador++

            println("ID: $id, Nombre: $nombre, Usuario: $user, Contraseña: $password, Teléfono: $tlf, Email: $email")
        }
        println("Hay $contador registros")
    } catch(e: Exception) {
        println("No se ha podido mostrar los datos")
        println()
    }
}

private fun menu() {
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
            2 -> menuUpdateData()
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