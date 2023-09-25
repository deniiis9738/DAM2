import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val f = File.listRoots()[0]
    var currentFile = f

    while (true) {
        if (currentFile.exists()) {
            if (currentFile.isDirectory()) {
                println()
                llistaDirectoriV(currentFile)
                currentFile = mouDirectoriV(currentFile)
            } else {
                println("No és un directori")
                println()
                mouDirectoriV(currentFile)
            }
        } else {
            println("No existeix el directori")
        }
    }
}

fun llistaDirectoriV(f: File) {
    val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
    println(s)
    println("-".repeat(s.length))
    var i = 0
    val lastModified = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date(f.lastModified()))
    println("0.- Directori pare")
    for (e in f.listFiles().sorted()) {
        i++
        var permisos = permisosDirectoriV(e)
        println("" + i + ".- " + permisos + " " + e.length() + "\t\t\t " + e.getName() + " " + lastModified)
    }
    println()
}

fun mouDirectoriV(f: File): File {
    var currentFile = f
    print("Introdueix un número (-1 per a acabar): ")
    var ent = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    if (ent == -1) {
        println("Programa finalitzat")
        exitProcess(0)
    } else if (ent > 0) {
        ent -= 1
        if (ent <= f.listFiles().size) {
            var archivoSeleccionado = f.listFiles().sorted().get(ent)
            if (archivoSeleccionado != null) {
                if (archivoSeleccionado.canRead()) {
                    currentFile = archivoSeleccionado
                } else {
                    println("No tens permisos")
                }
            }
        } else {
            println("Número incorrecte")
            println()
            mouDirectori(currentFile)
        }
    } else if (ent == 0) {
        if (f != null && f.parentFile != null && f.parentFile.exists()) {
            currentFile = f.parentFile
        }
    } else {
        println("Número incorrecte")
        println()
        mouDirectori(currentFile)
    }
    return currentFile
}

fun permisosDirectoriV(f: File): String {
    var texto = ""
    if (f.isFile()) {
        texto += "-"
    } else {
        texto += "d"
    }

    if (f.canRead()) {
        texto += "r"
    }else {
        texto += "-"
    }

    if (f.canWrite()) {
        texto += "w"
    }else {
        texto += "-"
    }

    if (f.canExecute()) {
        texto += "x"
    }else {
        texto += "-"
    }
    return texto
}