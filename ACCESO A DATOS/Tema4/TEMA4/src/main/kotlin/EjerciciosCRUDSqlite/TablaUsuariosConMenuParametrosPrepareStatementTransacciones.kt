package EjerciciosCRUDSqlite

import java.sql.DriverManager
import java.util.*
import kotlin.system.exitProcess

private val input = Scanner(System.`in`)
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
            "user TEXT UNIQUE, " +
            "password TEXT, " +
            "tlf TEXT, " +
            "email TEXT UNIQUE" +
            ")"

    try {
        st.executeUpdate(sentSQL)
    } catch (e: Exception) {
        println("La tabla ya existe")
    }
}

private fun insertData(nombre: String, usuario: String, contrasenia: String, tlf: String, email: String) {
    try {
        val insertUsuarioSQL = "INSERT INTO USUARIOS (nombre, user, password, tlf, email) VALUES (?, ?, ?, ?, ?)"
        var psNombre = con.prepareStatement(insertUsuarioSQL)
        psNombre.setString(1, nombre)
        psNombre.setString(2, usuario)
        psNombre.setString(3, contrasenia)
        psNombre.setString(4, tlf)
        psNombre.setString(5, email)

        psNombre.executeUpdate()

        selectData()
        println()
    } catch (e: Exception) {
        println("No se han podido introducir los datos")
        println()
    }
}

private fun menuInsertData() {
    println()
    print("INTRODUCE UN NOMBRE: ")
    val nombre =  input.next()
    print("INTRODUCE UN USUARIO: ")
    val usuario =  input.next()
    print("INTRODUCE UNA CONTRASEÑA: ")
    val contrasenia = input.next()
    print("INTRODUCE UN TELÉFONO: ")
    val tlf =  input.next()
    print("INTRODUCE UN EMAIL: ")
    val email =  input.next()
    println()

    insertData(nombre, usuario, contrasenia, tlf, email)
}

private fun updateData(id: Int, nombre: String, password: String) {
    try {
        val updateNombreSQL = "UPDATE USUARIOS SET nombre = ? WHERE id = ?"
        val updatePasswordSQL = "UPDATE USUARIOS SET password = ? WHERE id = ?"

        var psNombre = con.prepareStatement(updateNombreSQL)
        var psPassword = con.prepareStatement(updatePasswordSQL)
        psNombre.setString(1, nombre)
        psNombre.setInt(2, id)

        psPassword.setString(1, password)
        psPassword.setInt(2, id)

        psNombre.executeUpdate()
        psPassword.executeUpdate()

        selectData()
        println()
    } catch (e: Exception) {
        println("No se han podido actualizar los datos")
        println()
    }
}

private fun menuUpdateData() {
    println()
    print("INTRODUCE EL ID QUE QUIERES MODIFICAR: ")
    val id = input.nextInt()
    print("INTRODUCE EL NUEVO NOMBRE: ")
    val nuevoNombre =  input.next()
    print("INTRODUCE LA NUEVA CONTRASEÑA: ")
    val nuevaContrasenia = input.next()
    println()

    updateData(id, nuevoNombre, nuevaContrasenia)
}

private fun deleteData(id: Int) {
    try {
        val checkId = "SELECT id FROM USUARIOS WHERE id = ?"
        val psCheckId = con.prepareStatement(checkId)
        psCheckId.setInt(1, id)
        val resultSet = psCheckId.executeQuery()

        if (resultSet.next()) {
            val deleteUsuarioSQL = "DELETE FROM USUARIOS WHERE id = ?"
            var psId = con.prepareStatement(deleteUsuarioSQL)
            psId.setString(1, id.toString())

            psId.executeUpdate()
        } else {
            println("No existe el usuario mencionado.")
            println()
        }

        selectData()
        println()
    } catch (e: Exception) {
        println("No se han podido borrar los datos")
        println()
    }
}

private fun menuDeleteData() {
    println()
    print("INTRODUCE EL ID QUE QUIERES ELIMINAR: ")
    val id = input.nextInt()
    println()

    deleteData(id)
}

private fun deleteAllData() {
    try {
        val autocommit = con.autoCommit
        con.autoCommit = false
        st.executeUpdate("DELETE FROM USUARIOS")

        selectData()
        con.rollback()
        con.autoCommit = autocommit
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
        println("4- BORRAR TODOS LOS DATOS. (HAY TRANSACCIONES)")
        println("5- CREAR TABLA.")
        println("6- MOSTRAR DATOS.")
        println()
        print("Introduce la opción que deseas realizar: ")
        val opcion = input.nextInt()

        when(opcion) {
            0 -> exitProcess(0)
            1 -> menuInsertData()
            2 -> menuUpdateData()
            3 -> menuDeleteData()
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