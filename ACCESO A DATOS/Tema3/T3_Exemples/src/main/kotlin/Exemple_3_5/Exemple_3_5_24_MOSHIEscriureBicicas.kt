package Exemple_3_5

import com.squareup.moshi.*
import java.io.File

fun main(args: Array<String>) {
    val json = File("Bicicas.json").readText()

    val moshi = Moshi.Builder().build()
    val llistaTipus = Types.newParameterizedType(List::class.java, Estacions::class.java)
    val adapter: JsonAdapter<List<Estacions>> = moshi.adapter(llistaTipus)
    val estacions = adapter.fromJson(json)?.get(0)?.ocupacion

    val llistaEstDesti = arrayListOf<EstDesti>()
    val bicicas2 = Bicicas2(llistaEstDesti)
    if (estacions != null) {
        for (e in estacions)
            llistaEstDesti.add(EstDesti(e.id.toInt(),e.punto,e.puestos,e.ocupados,e.puestos-e.ocupados))
    }

    val adapter2 = moshi.adapter(Bicicas2::class.java)
    val json2 = adapter2.toJson(bicicas2)

    File("Bicicas2.json").writeText(json2)
}