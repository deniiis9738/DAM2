import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val f = File.listRoots()[0]
    var currentFile = f

    while (true) {
        if (currentFile.exists()) {
            if (currentFile.isDirectory()) {
                println()
                llistaDirectori(currentFile)
                currentFile = mouDirectori(currentFile)
            } else {
                println("No és un directori")
                println()
                mouDirectori(currentFile)
            }
        } else {
            println("No existeix el directori")
        }
    }
}

fun llistaDirectori(f: File) {
    val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
    println(s)
    println("-".repeat(s.length))
    var i = 0
    println("0.- Directori pare")
    for (e in f.listFiles().sorted()) {
        i++
        print("" + i + ".- ")
        if (e.isFile())
            println(e.getName() + "\t " + e.length())
        if (e.isDirectory())
            println(e.getName() + "\t <Directori>")
    }
    println()
}

fun mouDirectori(f: File): File {
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