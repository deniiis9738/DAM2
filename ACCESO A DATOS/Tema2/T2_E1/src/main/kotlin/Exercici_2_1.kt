import java.io.File

fun main(args: Array<String>){
    val f = File("Penyagolosa.bmp")

    val fi = FitxerImatge(f)
    fi.transformaNegatiu()
    fi.transformaObscur()
    fi.transformaBlancNegre()
}