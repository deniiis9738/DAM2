package PDF26.Problema1

fun main() {
    var clients = mutableListOf<Client>()

    var firstClient = Client("Geroge", 0f)
    var secondClient = Client("Carlos", 0f)
    var thirdClient = Client("Denis", 0f)

    clients.add(firstClient)
    clients.add(secondClient)
    clients.add(thirdClient)

    var bank = Bank(clients)
    bank.toCalculate()
    bank.totallyDeposits()
}