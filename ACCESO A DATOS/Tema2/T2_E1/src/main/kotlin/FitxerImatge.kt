import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class FitxerImatge(fEnt: File) {
    var f: File = File("")   // No modifiqueu aquesta línia. El seu valor s'ha de modificar en el constructor

    init {
        // Constructor
        // Control d'existència del fitxer i control de l'extensió .bmp (traure missatges d'error)
        // En cas que tot siga correcte, inicialitzar f amb fEnt
        if (fEnt.exists() && fEnt.extension == "bmp") {
            f = fEnt
        } else {
            println("El fichero o ruta indicada no existe.")
        }
    }

    fun transformaNegatiu() {
        // Transformar a negatiiu i guardar en _n.bmp
        val f_in = FileInputStream(f)
        val f_out = FileOutputStream("imatge1_n.bmp")

        var c = f_in.read()
        var byteCount = 0

        while (c!=-1){
            if (byteCount < 54) {
                f_out.write(c)
            } else {
                f_out.write(255 - c)
            }

            c = f_in.read()
            byteCount++
        }

        f_in.close()
        f_out.close()
    }

    fun transformaObscur() {
        // Transformar a una imatge més fosca i guardar en _o.bmp
        val f_in = FileInputStream(f)
        val f_out = FileOutputStream("imatge1_o.bmp")

        var c = f_in.read()
        var byteCount = 0

        while (c!=-1){
            if (byteCount < 54) {
                f_out.write(c)
            } else {
                f_out.write(c / 2)
            }

            c = f_in.read()
            byteCount++
        }

        f_in.close()
        f_out.close()
    }

    // Partvoluntària
    fun transformaBlancNegre() {
        // Transformar a una imatge en blanc i negre i guardar en _bn.bmp
        val f_in = FileInputStream(f)
        val f_out = FileOutputStream("imatge1_bn.bmp")

        var c = f_in.read()
        var byteCount = 0

        while (c!=-1){
            if (byteCount < 54) {
                f_out.write(c)
            } else {
                var r = c
                c = f_in.read()
                var g = c
                c = f_in.read()
                var b = c
                f_out.write((r + g + b) / 3)
                f_out.write((r + g + b) / 3)
                f_out.write((r + g + b) / 3)
            }

            c = f_in.read()
            byteCount++
        }

        f_in.close()
        f_out.close()
    }
}

