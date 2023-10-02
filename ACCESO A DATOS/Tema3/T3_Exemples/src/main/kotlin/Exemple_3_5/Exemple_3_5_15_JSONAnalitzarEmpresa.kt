package Exemple_3_5

import org.json.JSONTokener
import org.json.JSONObject
import java.io.FileReader

fun main(args: Array<String>) {

    val r_json = FileReader("Empresa.json")

    val arrel = JSONTokener(r_json).nextValue() as JSONObject
    val empresa = arrel.getJSONObject("empresa")

    for (e in empresa.getJSONArray("empleats")){
        val emp = e as JSONObject
        println("" + emp.get("nom") + " (" + emp.get("sou") + ")")
    }
}