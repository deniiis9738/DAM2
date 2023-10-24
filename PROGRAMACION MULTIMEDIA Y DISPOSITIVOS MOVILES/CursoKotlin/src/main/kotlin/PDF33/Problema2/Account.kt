package PDF33.Problema2

abstract class Account(name: String, amount: Long) {
    var name = ""
    var amount = 0L

    init {
        this.name = name
        this.amount = amount
    }

    open fun show() {
        println("Titular: $name")
        println("Monto: $amount")
    }
}