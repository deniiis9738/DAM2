package PDF34.Problema1

class SpacePoint(x: Int, y: Int): Point{
    var x = 0
    var y = 0

    init {
        this.x = x
        this.y = y
    }

    override fun show() {
        println("Punto en el espacio: ($x, $y)")
    }
}