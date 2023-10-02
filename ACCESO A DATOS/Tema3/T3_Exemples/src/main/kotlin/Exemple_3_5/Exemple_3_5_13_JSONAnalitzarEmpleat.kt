package Exemple_3_5

import org.json.JSONTokener
import org.json.JSONObject
import java.io.FileReader

fun main(args: Array<String>) {

    val r_json = FileReader("Empleat.json")

    val arrel = JSONTokener(r_json).nextValue() as JSONObject

    val empleat = arrel.get("empleat") as JSONObject

    println("" + empleat.get("nom") + " (" + empleat.get("sou") + ")")
}