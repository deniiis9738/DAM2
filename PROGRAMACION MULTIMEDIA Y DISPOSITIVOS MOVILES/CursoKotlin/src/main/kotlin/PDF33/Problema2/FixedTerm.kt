package PDF33.Problema2

class FixedTerm(name: String, amount: Long, term: Int, interest: Double): Account(name, amount) {
    var term = 0
    var interest = 0.0

    init {
        this.term = term
        this.interest = interest
    }

    override fun show() {
        println("Cuenta de plazo fijo")
        println("Plazo en días: $term")
        println("Intereses: $interest")
        val gain = amount * interest / 100
        println("Importe del intereés: $gain")
        super.show()
    }
}