package PDF26.Problema1

import java.util.*

class Bank(clients: MutableList<Client>) {
    var input = Scanner(System.`in`)

    var clients = mutableListOf<Client>()

    init {
        this.clients.addAll(clients)
    }

    fun toCalculate() {
        clients[0].toDeposit()
        clients[0].toImpress()
        clients[1].toSubstract()
        clients[1].toImpress()
        clients[2].toDeposit()
        clients[2].toSubstract()
        clients[2].toImpress()
    }

    fun totallyDeposits(): Float {
        var totally = 0f

        for (i in 0 ..< clients.size) {
            totally += clients[i].money
        }

        return totally
    }
}