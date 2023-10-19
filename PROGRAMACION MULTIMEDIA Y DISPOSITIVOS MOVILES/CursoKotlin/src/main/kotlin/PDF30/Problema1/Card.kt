package PDF30.Problema1

class Card(val type: CardType, val value: Int) {
    fun showCard() {
        println("Carta: $type con valor $value")
    }
}