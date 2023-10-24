package PDF33.Problema2

class SavingsBank(name: String, amount: Long): Account(name, amount) {
    override fun show() {
        println("Cuenta de caja de ahorros")
        super.show()
    }
}