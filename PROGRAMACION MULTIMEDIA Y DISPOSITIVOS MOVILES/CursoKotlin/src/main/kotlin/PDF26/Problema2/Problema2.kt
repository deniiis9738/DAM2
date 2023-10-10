package PDF26.Problema2

fun main() {
    var firstDice = Dice()
    var secondDice = Dice()
    var thirdDice = Dice()

    var firstDiceValue = firstDice.rollTheDice()
    var secondDiceValue = secondDice.rollTheDice()
    var thirdDiceValue = thirdDice.rollTheDice()

    println(firstDiceValue)
    println(secondDiceValue)
    println(thirdDiceValue)

    if (firstDiceValue == secondDiceValue && firstDiceValue == thirdDiceValue) {
        println("gano")
    } else {
        println("perdió")
    }
}