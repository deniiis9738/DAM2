package PDF31.Problema2

fun main() {
    val dice = object {
        val array = IntArray(5)

        fun generate() {
            for (i in array.indices) {
                array[i] = ((Math.random() * 6) + 1).toInt()
            }
        }

        fun showDice() {
            for (element in array) {
                print("$element ")
            }
        }

        fun greater(): Int {
            var bigger = array[0]

            for (i in array.indices) {
                if (array[i] > bigger) {
                    bigger = array[i]
                }
            }
            return bigger
        }
    }

    dice.generate()
    dice.showDice()
    println()
    println(dice.greater())
}