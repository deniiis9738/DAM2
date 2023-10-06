package PDF26.Problema1

import java.util.Scanner

class Client(name: String, money: Float) {
    var input = Scanner(System.`in`)

    var name = ""
    var money = 0f

    init {
        this.name = name
        this.money = money
    }

    fun toDeposit(): Float {
        print("¿Cuánto quiere depositar: ")
        var deposit = input.nextFloat()
        money += deposit
        return deposit
    }

    fun toSubstract(): Float {
        print("¿Cuánto quiere extraer: ")
        var substract = input.nextFloat()
        money -= substract
        return substract
    }

    fun toImpress() {
        println("A $name le quedan $money€ en el depósito")
    }
}